package reservation.model.dao;

import common.excption.TimeException;
import reservation.model.dto.Seat;

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

    public ArrayList<Seat> selectAll(Connection conn, String timeCode, String serviceCode) throws TimeException {
        ArrayList<Seat> list = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        String[] serviceCodes = serviceCode.split(", "); // 쉼표 + 공백 기준으로 문자 분리

        StringBuilder questionMarks = new StringBuilder();
        for (int i = 0; i < serviceCodes.length; i++) { // 문자 개수에 따라 ? 추가
            questionMarks.append("?");
            if (i < serviceCodes.length - 1) {
                questionMarks.append(", ");
            }
        }

        // properties는 ? 생성이 불가능해 따로 사용 안함
        String sql = "SELECT A.SEAT_CODE " +
                     "FROM SEAT A " +
                     "LEFT JOIN SEAT_SERVICE_MAP B ON A.SEAT_CODE = B.SEAT_CODE " +
                     "LEFT JOIN RESERVATION C ON B.SEAT_CODE = C.RSV_SEAT_CODE AND C.RSV_TIME_CODE = ? " +
                     "JOIN SERVICE D ON B.SERVICE_CODE = D.SERVICE_CODE " +
                     "WHERE D.SERVICE_CODE IN (" + questionMarks.toString() + ") AND C.RSV_NO IS NULL " +
                     "ORDER BY A.SEAT_CODE";


//        String sql = prop.getProperty("seviceSeatSelectAll");
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
            throw new TimeException("selectAll 에러 : " + e.getMessage());
        } finally {
            close(rs);
            close(ps);
        }
        return list;
    }
}