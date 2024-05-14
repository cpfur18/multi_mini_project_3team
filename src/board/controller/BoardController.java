package board.controller;

import board.model.Post;
import board.service.BoardService;
import board.view.ListDetailView;
import board.view.ListView;
import board.view.MenuView;

import java.util.List;

public class BoardController {
    BoardService boardService;
    public static int memberNo = 1;
    public static boolean admin = true;

    public BoardController() {
        boardService = new BoardService();
    }

    public void run() {
        int input;

        MenuView.displayView();
        input = MenuView.getUserInput();

        switch (input) {
            case 1:
                // 게시글 조회 로직 수행
                displayList();
                break;
            case 2:
                // 글쓰기 로직 수행
                System.out.println("글쓰기 기능을 실행합니다.");
                break;
            case 0:
                // 프로그램 종료
                System.out.println("이전으로 돌아갑니다.");
                return;
            default:
                // 잘못된 입력 처리
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
        }
    }

    private void displayList() {
        List<Post> posts = boardService.getAllPosts();
        ListView.displayList(posts);
        int input = ListView.getUserInput();
        if (input == 0) {
            run();
        } else {
            Post findPost = boardService.findOnePost(input);
            ListDetailView.displayList(findPost);
            input = ListDetailView.getUserInput();
            if (input == 0) {
                displayList();
            } else if (input == 1) {
                if (memberNo == findPost.getMemberNo()) {
                    System.out.println("게시글을 수정합니다.");
                } else if (admin) {
                    System.out.println("게시글을 삭제합니다.");
                } else {
                    System.out.println("권한이 없습니다.");
                }
            } else if (input == 2) {
                if (admin) {
                    System.out.println("게시글을 삭제합니다.");
                } else {
                    System.out.println("권한이 없습니다.");
                }
            }
        }

    }
}
