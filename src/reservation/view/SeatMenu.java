package reservation.view;

public class SeatMenu {
    private ViewUtils viewUtils = new ViewUtils();
    int answer = 0;

    public void seatMenu() { // 좌석 선택 화면

        System.out.println("╔══════════════════════════ Café Layout ══════════════════════════╗");
        System.out.println("║  |   1  |   2  |   3  |   4  |   5  |   6  |   7  |   8  |   9  |");
        System.out.println("║─────────────────────────────────────────────────────────────────║");
        System.out.println("║ A | [X] |  [ ] |  [X] |  [X] |  [ ] |  [O] |  [O] |  [X] |  [X] |");
        System.out.println("║─────────────────────────────────────────────────────────────────║");
        System.out.println("║ B | [ ] |  [X] |  [ ] |  [X] |  [ ] |  [X] |  [ ] |  [ ] |  [X] |");
        System.out.println("║─────────────────────────────────────────────────────────────────║");
        System.out.println("║ C | [X] |  [X] |  [ ] |  [ ] |  [ ] |  [ ] |  [X] |  [ ] |  [ ] |");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");

    }
}
