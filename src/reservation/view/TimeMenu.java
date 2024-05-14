package reservation.view;

import java.util.Scanner;

public class TimeMenu {
    private static Scanner sc = new Scanner(System.in); // Scanner 객체 생성
    int answer = 0; // 답변 저장

    public void timeMenu(){
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
            System.out.printf("번호를 입력하세요 : ");
            answer = sc.nextInt();

            switch (answer) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:

                case 4:

                case 5:

                case 6:
                    break;
                default:
                    new ReservationMenu().printErrorMessage();
            }
        }while (true);

    }
}
