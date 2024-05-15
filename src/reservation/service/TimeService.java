package reservation.service;

import common.excption.TimeException;
import reservation.model.dao.TimeDao;
import reservation.model.dto.Time;

import java.sql.Connection;

import static common.JDBCTemplate.getConnection;

public class TimeService {

    private final TimeDao timeDao;

    public TimeService() {
        timeDao = new TimeDao();
    }

    public Time selectOne(String timeCode) throws TimeException {
        Connection conn = getConnection();
        Time t = timeDao.selectOne(conn, timeCode);

        return t;
    }
}
