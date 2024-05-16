package reservation.view;

import reservation.controller.SeatConrtoller;
import reservation.model.dto.Seat;
import reservation.service.SeatService;

import java.util.ArrayList;
import java.util.Scanner;

public class SeatMenu {
    private ViewUtils viewUtils = new ViewUtils();
    private SeatConrtoller seatConrtoller = new SeatConrtoller();
    private SeatService seatService = new SeatService();
    Scanner sc = new Scanner(System.in);
    String answer;

    public void seatMenu(String timeCode, String serviceList, int memberNO) { // 좌석 선택 화면

        String pattern = "[A-C][1-9]"; // 정규식 사용을 위한 변수
        ArrayList<Seat> seatList = null;

        System.out.println("╔═══════════════════════ 좌석 예약 ═══════════════════════╗");
        System.out.println("║   |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  ║");
        System.out.println("║─────────────────────────────────────────────────────────║");
        seatList = seatService.isService(timeCode, serviceList);
        System.out.println("╚═════════════════════════════════════════════════════════╝");

        while (true) {
            System.out.print("예약할 좌석을 입력해주세요 : ");
            String answer = sc.next();

            if (answer.matches(pattern)) { // 정규식에 맞는지 확인
                if (seatService.isSelectSeat(seatList, answer)) {
                    System.out.println(answer + " 좌석을 예약 하셨습니다.");
                    System.out.println("상품 선택 화면으로 이동합니다.");
                    new ProductMenu().prdMainMenu(timeCode, serviceList, answer, memberNO);
                    break;
                } else {
                    System.out.println("선택한 좌석은 이미 예약된 좌석입니다.");
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }

    }

    public void display(ArrayList<Seat> seatList){ // 빈 좌석 출력 메서드
        char[] seatPattern = {'A', 'B', 'C'};

        for (char s : seatPattern) {
            System.out.print("║ " + s + " | ");
            for (int j = 1; j <= 9; j++) {
                String seatCode = s + String.valueOf(j);
                // seatList를 돌면서 스트림으로 변환, anyMatch는 조건 만족하면 true, DTO에서 getSeatCode 호출 seatCode과 동일 시 빈 좌석
                if (seatList.stream().anyMatch(seat -> seat.getSeatCode().equals(seatCode))) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[X]");
                }
                System.out.print(" | ");
            }
            System.out.println();
            System.out.println("║─────────────────────────────────────────────────────────║");
        }
    }
}
