package reservation.model.dao;

import common.excption.Exception;
import reservation.model.dto.Seat;
import reservation.service.SeatService;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import static common.JDBCTemplate.close;

public class SeatDao {
    private Properties prop = null;

    public SeatDao() {
        try {
            prop = new Properties();
            prop.load(new FileReader("resources/query.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Seat> selectAll(Connection conn, String timeCode) throws Exception {
        ArrayList<Seat> list = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = prop.getProperty("revSeatSelectAll");
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, timeCode);


            rs = ps.executeQuery();

            list = new ArrayList<Seat>();

            while (rs.next()) {
                Seat s = new Seat();

                s.setSeatCode(rs.getString("SEAT_CODE"));
                list.add(s);
            }

        } catch (SQLException e) {
            throw new Exception("selectAll 에러 : " + e.getMessage());
        } finally {
            close(rs);
            close(ps);
        }
        return list;
    }

    public ArrayList<Seat> selectAll2(Connection conn, String timeCode, String serviceCode) throws Exception {
        ArrayList<Seat> list = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        String[] serviceCodes = serviceCode.split(", "); // 쉼표 + 공백 기준으로 문자 분리

        // properties는 ? 생성이 불가능해 따로 사용 안함
        String sql = new SeatService().setSeatSql(serviceCodes);

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, timeCode);

            for (int i = 0; i < serviceCodes.length; i++) {
                ps.setString(i + 2, serviceCodes[i]);
            }
            ps.setString(2, serviceCode);

            rs = ps.executeQuery();

            list = new ArrayList<Seat>();

            while (rs.next()) {
                Seat s = new Seat();

                s.setSeatCode(rs.getString("SEAT_CODE"));
                list.add(s);
            }

        } catch (SQLException e) {
            throw new Exception("selectAll 에러 : " + e.getMessage());
        } finally {
            close(rs);
            close(ps);
        }
        return list;
    }
}