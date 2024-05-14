package board.view;

import board.model.Post;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public final class ListView {
    public static void displayList(List<Post> posts) {

        System.out.println("=========================");

        if (posts.size() == 0) {
            System.out.println("등록된 게시글이 없습니다.");
        } else {
            for (Post post : posts) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                System.out.println(post.getPostId() + ". " + post.getTitle() + " - " + post.getDate().format(formatter));
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
