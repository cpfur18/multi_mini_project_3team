package reservation.service;

import common.excption.TimeException;
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

    public ArrayList<Seat> selectAll(String timeCode, String serviceCode) throws TimeException {
        Connection conn = getConnection();
        ArrayList<Seat> seats = seatDao.selectAll(conn, timeCode, serviceCode);

        return seats;
    }
}
