package reservation.view;

import reservation.controller.ReservationController;

import java.util.Scanner;

public class ReservationMenu {
    private static Scanner sc = new Scanner(System.in); // Scanner 객체 생성
    private ViewUtils viewUtils = new ViewUtils();
    int answer = 0;

    public void resMainMenu(){ // 예약 메인 화면(메서드 체인)
        do {
            System.out.println("┌────────────────────────────────────────────────────┐");
            System.out.println("│                             카페 예약 관리 서비스  │");
            System.out.println("│                  **티데이**                        │");
            System.out.println("│                                                    │");
            System.out.println("│                                                    │");
            System.out.println("│                                                    │");
            System.out.println("│ [카페예약]                                         │");
            System.out.println("│ 1. 예약하기                                        │");
            System.out.println("│ 2. 예약조회                                        │");
            System.out.println("│ 0. 돌아가기                                        │");
            System.out.println("└────────────────────────────────────────────────────┘");
            System.out.printf("번호를 입력하세요 : ");
            answer = sc.nextInt();

            switch (answer) {
                case 1:
                    System.out.println("예약 하기를 선택하셨습니다.");
                    reservation();
                    break;
                case 2:
                    System.out.println("예약 조회를 선택하셨습니다.");
                    
                    break;
                case 0:
                    // 회원 메인 화면으로 이동 - 추후 통합 예정
                    return;
                default:
                    viewUtils.printErrorMessage();
            }
        } while (true);
    }

    public void reservation() { // 예약 시작
        do {
            System.out.println("┌────────────────────────────────────────────────────┐");
            System.out.println("│                             카페 예약 관리 서비스  │");
            System.out.println("│                  **티데이**                        │");
            System.out.println("│                                                    │");
            System.out.println("│                                                    │");
            System.out.println("│ [카페예약]                                         │");
            System.out.println("│                                                    │");
            System.out.println("│ 예약을 시작합니다.                                 │");
            System.out.println("│ 예약을 원하는 시간대를 선택해 주세요.              │");
            System.out.println("│ 시간 선택하기(1) | 돌아가기(0)                     │");
            System.out.println("└────────────────────────────────────────────────────┘");
            System.out.printf("번호를 입력하세요 : ");
            answer = sc.nextInt();
            
            switch (answer) {
                case 0:
                    System.out.println("이전 화면으로 돌아갑니다.");
                    return;
                case 1:
                    System.out.println("예약 시간을 선택합니다.");
                    new ServiceMenu().serviceMenu();
                    break;
                default:
                    viewUtils.printErrorMessage();
            }
        } while (true);

    }

    public void payMent() {

    }

}
