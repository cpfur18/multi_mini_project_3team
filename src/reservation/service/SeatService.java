package reservation.service;

import common.excption.Exception;
import reservation.model.dao.SeatDao;
import reservation.model.dto.Seat;

import java.sql.Connection;
import java.util.ArrayList;

import static common.JDBCTemplate.getConnection;

public class SeatService {

    private final SeatDao seatDao;

    public SeatService() {
        seatDao = new SeatDao();
    }

    public ArrayList<Seat> selectAll(String timeCode) throws Exception {
        Connection conn = getConnection();
        ArrayList<Seat> seats = seatDao.selectAll(conn, timeCode);

        return seats;
    }

    public ArrayList<Seat> selectAll2(String timeCode, String serviceCode) throws Exception {
        Connection conn = getConnection();
        ArrayList<Seat> seats = seatDao.selectAll2(conn, timeCode, serviceCode);

        return seats;
    }

    public String setSeatSql(String[] serviceCodes){
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
        return sql;
    }
}
