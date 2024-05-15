package reservation.controller;

import common.excption.Exception;
import reservation.model.dto.Seat;
import reservation.service.SeatService;
import reservation.view.SeatMenu;

import java.util.ArrayList;

public class SeatConrtoller {
    private SeatService seatService = new SeatService();

    public ArrayList<Seat> selectAll(String timeCode) {
        ArrayList<Seat> s = null;
        SeatMenu menu = new SeatMenu();
        try {
            s = seatService.selectAll(timeCode);
            if (s != null) {

            }else{
                System.out.println("데이터없음" + s);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("조회실패" + s);
        }
        return s;
    }

    public ArrayList<Seat> selectAll2(String timeCode, String serviceCode) {
        ArrayList<Seat> s = null;
        SeatMenu menu = new SeatMenu();
        try {
            s = seatService.selectAll2(timeCode, serviceCode);
            if (s != null) {

            }else{
                System.out.println("데이터없음" + s);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("조회실패" + s);
        }
        return s;
    }
}
