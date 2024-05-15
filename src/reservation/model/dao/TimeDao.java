package reservation.model.dao;

import common.excption.TimeException;
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
            //  prop.loadFromXML(new FileInputStream("mapper/query.xml"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Time selectOne(Connection conn, String timeCode) throws TimeException {
        Time rsDto = null;

        PreparedStatement ps = null;
        ResultSet rs = null;// Select 한후 결과값 받아올 객체

        String sql= prop.getProperty("timeSelectOne");
        timeCode = "T" + timeCode;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, timeCode);
            rs = ps.executeQuery();

            if (rs.next()) { // 결과 집합에 데이터가 있는 경우에만 처리
                rsDto = new Time();
                rsDto.setStartTime(rs.getString("START_TIME"));
                rsDto.setEndTime(rs.getString("END_TIME"));
            }

        } catch (SQLException e) {
            throw new TimeException(e.getMessage());

        } finally {
            close(ps);
            close(rs);
        }
        return rsDto;
    }
}
