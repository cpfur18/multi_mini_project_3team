package reservation.controller;

import reservation.service.ReservationService;
import reservation.view.ViewUtils;

public class ReservationController {
    ViewUtils viewUtils = new ViewUtils();
    private ReservationService reservationService = new ReservationService();

    public void insertReservation(String timeCode, String seatCode, int totalMoney, int memberNO) {
        int result = 0;
        try {
            result = reservationService.insertReservation(timeCode, seatCode, totalMoney, memberNO);
            if(result > 0){
                viewUtils.printMessage("예약 완료");
            }
        } catch (Exception e) {
            e.printStackTrace();
            viewUtils.printMessage("예약 실패");
        }
    }
}
