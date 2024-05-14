package board.view;

import board.controller.BoardController;
import board.model.Post;
import board.service.BoardService;

import java.util.List;
import java.util.Scanner;

public final class ListView {
    public static void displayList(List<Post> posts) {

        System.out.println("=========================");

        if (posts.size() == 0) {
            System.out.println("등록된 게시글이 없습니다.");
        } else {
            for (int i = 0; i < posts.size(); i++) {
                Post post = posts.get(i);
                System.out.println(post.getPostId() + ". " + post.getTitle());
            }
        }
        System.out.println("—----------------------------------");
        System.out.println("0. 게시글 관리");
        System.out.println("=========================");
        System.out.print("번호를 입력하세요: ");
    }

    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
