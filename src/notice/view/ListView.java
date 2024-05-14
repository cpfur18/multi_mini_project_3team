package notice.view;

import notice.controller.NoticeController;
import notice.model.Post;

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
        System.out.println("0. 돌아가기");
        if (NoticeController.admin) {
            System.out.println("w. 공지사항 쓰기");
        }
        System.out.println("=========================");
        System.out.print("명령어를 입력하세요: ");
    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
