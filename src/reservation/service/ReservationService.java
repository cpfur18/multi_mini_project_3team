package reservation.service;

import reservation.model.dao.ResverationDao;

import java.sql.Connection;

import static common.JDBCTemplate.*;

public class ReservationService {
    public int insertReservation(String timeCode, String seatCode, int totalMoney, int memberNO)  throws Exception  {
        ResverationDao resverationDao = new ResverationDao();
        Connection conn = getConnection();
        int result = resverationDao.insertResveration(conn, timeCode, seatCode, totalMoney, memberNO);

        if (result > 0) commit(conn);
        else rollback(conn);

        return result;
    }
}
