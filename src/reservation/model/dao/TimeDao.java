package reservation.model.dao;

import common.excption.Exception;
import reservation.model.dto.Time;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static common.JDBCTemplate.close;

public class TimeDao {
    private Properties prop = null;

    public TimeDao() {
        try {
            prop = new Properties();
            prop.load(new FileReader("resources/query.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Time selectOne(Connection conn, String timeCode) throws Exception {
        Time rsDto = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql= prop.getProperty("timeSelectOne");
        timeCode = "T" + timeCode;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, timeCode);
            rs = ps.executeQuery();

            if (rs.next()) {
                rsDto = new Time();
                rsDto.setStartTime(rs.getString("START_TIME"));
                rsDto.setEndTime(rs.getString("END_TIME"));
            }

        } catch (SQLException e) {
            throw new Exception(e.getMessage());

        } finally {
            close(ps);
            close(rs);
        }
        return rsDto;
    }
}
