package notice.service;

import notice.dao.NoticeDAO;
import notice.model.Post;

import java.util.List;

public class NoticeService {
    private NoticeDAO noticeDAO;

    public NoticeService() {
        this.noticeDAO = new NoticeDAO();
    }

    public List<Post> getAllPosts() {
        return noticeDAO.getAllPosts();
    }

    public Post findOnePost(Integer postId) {
        return noticeDAO.findOnePost(postId);
    }

    public void writePost(String title, String content, int memberNo) {
        Post post = new Post(title, content, memberNo);
        noticeDAO.writePost(post);
    }

    public void modifyPost(Post post) {
        noticeDAO.modifyPost(post);
    }

    public void deletePost(Integer postId) {
        noticeDAO.deletePost(postId);
    }


}
