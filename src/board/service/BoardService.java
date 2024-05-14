package board.service;

import board.dto.BoardDAO;
import board.model.Post;

import java.util.List;

public class BoardService {
    private BoardDAO boardDAO;

    public BoardService() {
        this.boardDAO = new BoardDAO();
    }

    public List<Post> getAllPosts() {
        return boardDAO.getAllPosts();
    }

    public Post findOnePost(int postId) {
        return boardDAO.findOnePost(postId);
    }

    public void writePost(String title, String content, int memberNo) {
        Post post = new Post(title, content, memberNo);
        boardDAO.writePost(post);
    }

    public void modifyPost(Post post) {
        boardDAO.modifyPost(post);
    }

    public void deletePost(Integer postId) {
        boardDAO.deletePost(postId);
    }


}
