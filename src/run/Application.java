package run;

import reservation.view.ReservationMenu;

public class Application {
    public static void main(String[] args) {
        // 메인 실행 파일

        // Test
//        new ProductMenu().prdMainMenu();
//        new SeatMenu().seatMenu("T1", "S1, S2", 2);
        new ReservationMenu().resMainMenu(1);
//        new PayMenu().payMenu(timeCode, serviceList);
    }

}
