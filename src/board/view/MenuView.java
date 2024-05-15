package board.view;

import java.util.Scanner;

public final class MenuView {

    private static final String MENU_TITLE = "┌────────────────────────────────────────────────────┐\n" +
            "│                             카페 예약 관리 서비스       │\n" +
            "│                  **티데이**                          │\n" +
            "│                                                    │\n" +
            "│                                                    │\n" +
            "│                                                    │\n" +
            "│ [게시글 관리]                                         │\n" +
            "│ 1. 게시글 조회                                        │\n" +
            "│ 2. 글쓰기                                            │\n" +
            "│ 0. 돌아가기                                           │\n" +
            "└────────────────────────────────────────────────────┘\n";

    public static void displayView() {
        System.out.println(MENU_TITLE);
        System.out.print("번호를 입력하세요 : ");
    }

    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }
}
