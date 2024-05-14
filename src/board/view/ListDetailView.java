package board.view;

import board.controller.BoardController;
import board.model.Post;

import java.util.Scanner;

public class ListDetailView {

    public static void displayList(Post post) {
        System.out.println("=========================");
        System.out.print("제목: ");
        System.out.print(post.getTitle() + "\n");
        System.out.println("—------------------------");
        System.out.println(post.getContent());
        System.out.println("—------------------------");
        System.out.println("0. 게시글 조회");
        if (BoardController.memberNo == post.getMemberNo()) {
            System.out.println("1. 수정");
        }
        if (BoardController.admin) {
            if (BoardController.memberNo == post.getMemberNo()) {
                System.out.println("2. 삭제");
            } else {
                System.out.println("1. 삭제");
            }
        }
        System.out.println("=========================");
        System.out.print("번호를 입력하세요: ");
    }

    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
