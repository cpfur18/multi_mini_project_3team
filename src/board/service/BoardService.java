package board.service;

import board.dto.BoardDAO;
import board.model.Post;
import board.view.MenuView;

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


}
