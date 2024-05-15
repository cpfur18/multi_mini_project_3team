package reservation.controller;

import common.excption.Exception;
import reservation.model.dto.Seat;
import reservation.service.SeatService;
import reservation.view.ViewUtils;

import java.util.ArrayList;

public class SeatConrtoller {


    public ArrayList<Seat> selectAll(String timeCode) {
        ViewUtils viewUtils = new ViewUtils();
        SeatService seatService = new SeatService();
        ArrayList<Seat> s = null;
        try {
            s = seatService.selectAll(timeCode);
            if (s != null) {

            }else{
                viewUtils.printNoData();
            }
        } catch (Exception e) {
            e.printStackTrace();
            viewUtils.printQueryFailed();
        }
        return s;
    }

    public ArrayList<Seat> selectAll2(String timeCode, String serviceCode) {
        SeatService seatService = new SeatService();
        ViewUtils viewUtils = new ViewUtils();
        ArrayList<Seat> s = null;
        try {
            s = seatService.selectAll2(timeCode, serviceCode);
            if (s != null) {

            }else{
                viewUtils.printNoData();
            }
        } catch (Exception e) {
            e.printStackTrace();
            viewUtils.printQueryFailed();
        }
        return s;
    }
}
