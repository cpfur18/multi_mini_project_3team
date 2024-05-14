package board.view;

import java.util.Scanner;

public class WriteView {
    public static String getTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================");
        System.out.print("제목: ");
        return scanner.nextLine();

    }

    public static String getContent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("—------------------------");
        return scanner.nextLine();
    }
}
