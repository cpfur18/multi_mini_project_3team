package notice.view;

import notice.controller.NoticeController;
import notice.model.Post;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ListDetailView {

    public static void displayList(Post post) {

        System.out.println("=========================");
        System.out.print("제목: ");
        System.out.print(post.getTitle() + "\n");
        System.out.print("작성일: ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.print(post.getDate().format(formatter) + "\n");
        System.out.println("—------------------------");
        System.out.println(post.getContent());
        System.out.println("—------------------------");
        System.out.println("0. 공지사항 조회");
        if (NoticeController.admin) {
            System.out.println("1. 수정");
            System.out.println("2. 삭제");
        }
        System.out.println("=========================");
        System.out.print("번호를 입력하세요: ");
    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
