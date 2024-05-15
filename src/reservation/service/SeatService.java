package reservation.service;

import common.excption.Exception;
import reservation.controller.SeatConrtoller;
import reservation.model.dao.SeatDao;
import reservation.model.dto.Seat;
import reservation.view.SeatMenu;

import java.sql.Connection;
import java.util.ArrayList;

import static common.JDBCTemplate.getConnection;

public class SeatService {

    private final SeatDao seatDao;
    private SeatConrtoller seatConrtoller = new SeatConrtoller();


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

    public ArrayList<Seat> isService(String timeCode, String service) {
        SeatMenu seatMenu = new SeatMenu();
        ArrayList<Seat> seatList = null;
        if (service == null) {
            seatList = seatConrtoller.selectAll(timeCode);
            seatMenu.display(seatList);
        } else {
            seatList = seatConrtoller.selectAll2(timeCode, service);
            seatMenu.display(seatList);
        }
        return seatList;
    }

    public boolean isSelectSeat(ArrayList<Seat> seatList, String answer) {
        // anyMatch 최소한 한 개의 요소가 주어진 조건을 만족하는지 조사
        // 입력받은 좌석이 있으면 TRUE
        boolean isEmpty = seatList.stream().anyMatch(seat -> seat.getSeatCode().equals(answer));
        if (isEmpty) {
            return true;
        } else {
            return false;
        }
    }

    public String setSeatSql(String[] serviceCodes) {
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
