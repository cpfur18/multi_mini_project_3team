package notice.controller;

import notice.model.Post;
import notice.service.NoticeService;
import notice.view.*;

import java.util.List;

public class NoticeController {
    NoticeService noticeService;
    public static int memberNo = 1;
    public static boolean admin = false;

    public NoticeController() {
        noticeService = new NoticeService();
    }

    public void run() {
        displayList();
    }

    private void displayList() {
        List<Post> posts = noticeService.getAllPosts();
        ListView.displayList(posts);
        String input = ListView.getUserInput();
        if ("0".equals(input)) {
            System.out.println("이전으로 돌아갑니다.");
        } else if ("w".equals(input)) {
            if (admin) {
                writePost();
            } else {
                System.out.println("권한이 없습니다.");
                displayList();
            }
        } else {
            Post findPost = noticeService.findOnePost(Integer.parseInt(input));
            ListDetailView.displayList(findPost);
            input = ListDetailView.getUserInput();
            if ("0".equals(input)) {
                displayList();
            } else if ("1".equals(input)) {
                modifyPost(findPost);
            } else if ("2".equals(input)) {
                deletePost(findPost.getPostId());
            }
        }
    }

    private void writePost() {
        String title = WriteView.getTitle();
        String content = WriteView.getContent();
        noticeService.writePost(title, content, memberNo);
        displayList();
    }
    private void modifyPost(Post post) {
        String title = WriteView.getTitle();
        String content = WriteView.getContent();
        noticeService.modifyPost(new Post(post.getPostId(), title, content, memberNo));
        displayList();
    }

    private void deletePost(Integer postId) {
        noticeService.deletePost(postId);
        displayList();
    }

}
