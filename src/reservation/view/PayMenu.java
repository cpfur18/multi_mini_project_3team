package reservation.view;

import reservation.controller.ProductController;
import reservation.controller.ReservationController;

import java.util.ArrayList;
import java.util.Scanner;

public class PayMenu {
    Scanner sc = new Scanner(System.in);
    ViewUtils viewUtils = new ViewUtils();
    private ReservationController reservationController = new ReservationController();
    int answer;

    public void payMenu(String timeCode, String serviceList, String seatCode, ArrayList<String> prdInputList, int memberNO) {
        int totalMoney = new ProductController().selectTotalMoney(prdInputList);
        do {
            System.out.println("┌────────────────────────────────────────────────────┐");
            System.out.println("│                             카페 예약 관리 서비스  │");
            System.out.println("│                  **티데이**                        │");
            System.out.println("│                                                    │");
            System.out.println("│                                                    │");
            System.out.println("│                                                    │");
            System.out.println("│ [결제]                                             │");
            System.out.println("│ 결제방법                                           │");
            System.out.println("│ 1. 카드 결제                                       │");
            System.out.println("│ 2. 무통장 입금                                     │");
            System.out.println("│ 0. 돌아가기                                        │");
            System.out.println("└────────────────────────────────────────────────────┘");
            System.out.println("총 가격 :" + totalMoney + "원");
            System.out.printf("번호를 입력하세요 : ");
            answer = sc.nextInt();

            switch (answer) {
                case 0:
                    System.out.println("이전 화면으로 돌아갑니다.");
                    new ProductMenu().prdMainMenu(timeCode, serviceList, seatCode, memberNO);
                    return;
                case 1: case 2:
                    System.out.println("결제가 완료되었습니다.");

                    reservationController.insertReservation(timeCode, seatCode, totalMoney, memberNO);

                    System.out.println("초기화면으로 돌아갑니다.");
                    new ReservationMenu().resMainMenu(memberNO);
                    break;
                default:
                    viewUtils.printErrorMessage();
            }
        } while (true);

    }
}
