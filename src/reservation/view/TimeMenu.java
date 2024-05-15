package reservation.view;

import reservation.controller.TimeController;

import java.util.Scanner;

public class TimeMenu {
    private static Scanner sc = new Scanner(System.in); // Scanner 객체 생성
    private ViewUtils viewUtils = new ViewUtils();
    private TimeController timeController = new TimeController();

    int answer = 0; // 답변 저장

    public void timeMenu(String serviceList){
        do {
            System.out.println("┌───────────────────────────────────────┐");
            System.out.println("│         카페 예약 관리 서비스         │");
            System.out.println("│               **티데이**              │");
            System.out.println("│                                       │");
            System.out.println("│                  오전                 │");
            System.out.println("│     ┌─────1─────┐     ┌─────2─────┐   │");
            System.out.println("│     │ 08:00 -   │     │ 10:00 -   │   │");
            System.out.println("│     │ 10:00     │     │ 12:00     │   │");
            System.out.println("│     └───────────┘     └───────────┘   │");
            System.out.println("│                  오후                 │");
            System.out.println("│     ┌─────3─────┐     ┌─────4─────┐   │");
            System.out.println("│     │ 12:00 -   │     │ 14:00 -   │   │");
            System.out.println("│     │ 14:00     │     │ 16:00     │   │");
            System.out.println("│     └───────────┘     └───────────┘   │");
            System.out.println("│                                       │");
            System.out.println("│     ┌─────5─────┐     ┌─────6─────┐   │");
            System.out.println("│     │ 16:00 -   │     │ 18:00 -   │   │");
            System.out.println("│     │ 18:00     │     │ 20:00     │   │");
            System.out.println("│     └───────────┘     └───────────┘   │");
            System.out.println("└───────────────────────────────────────┘");
            System.out.println("돌아가시려면 0을 입력해주세요.");
            System.out.printf("번호를 입력하세요 : ");
            answer = sc.nextInt();

            switch (answer) {
                case 1: case 2: case 3: case 4: case 5:  case 6: {
                    timeController.timeSelect(answer);
                    System.out.println("좌석 선택 화면으로 이동합니다.");
                    String answer2 = "T" + answer;
                    new SeatMenu().seatMenu(answer2, serviceList);
                }
                case 0:
                    System.out.println("이전 화면으로 이동합니다.");
                    new ServiceMenu().serviceMenu();
                default: viewUtils.printErrorMessage();
            }
        }while (true);
    }

    public void displayMessage(String message) {
        System.out.println(message);

    }
}
