package notice.dto;
import notice.model.Post;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NoticeDAO {
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    String username = "caf";
    String password = "caf";

    // 게시글 테이블의 컬럼명 정의
    private static final String TABLE_NAME = "NOTICE";
    private static final String POST_ID_COLUMN = "POST_ID";
    private static final String POST_DATE_COLUMN = "POST_DATE";
    private static final String TITLE_COLUMN = "TITLE";
    private static final String CONTENT_COLUMN = "CONTENT";
    private static final String MEMBER_NO_COLUMN = "MEMBER_NO";

    // 데이터베이스 연결을 위한 메서드
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME + " ORDER BY POST_ID";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int postId = rs.getInt(POST_ID_COLUMN);
                String title = rs.getString(TITLE_COLUMN);
                LocalDate date = rs.getDate(POST_DATE_COLUMN).toLocalDate();
                String content = rs.getString(CONTENT_COLUMN);
                int memberNo = rs.getInt(MEMBER_NO_COLUMN);

                Post post = new Post(postId, date, title, content, memberNo);
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    public void writePost(Post post) {
        String query = "INSERT INTO " + TABLE_NAME + " (" + POST_ID_COLUMN + ", " + TITLE_COLUMN + ", " + CONTENT_COLUMN + ", " + MEMBER_NO_COLUMN + ") VALUES (SEQ_NOTICE.NEXTVAL, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.setInt(3, post.getMemberNo());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void modifyPost(Post post) {
        String query = "UPDATE " + TABLE_NAME + " SET " + TITLE_COLUMN + "= ?, " + CONTENT_COLUMN + "= ?, " + POST_DATE_COLUMN + "= SYSDATE " + "WHERE " + POST_ID_COLUMN + "= ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.setInt(3, post.getPostId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePost(Integer postId) {
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + POST_ID_COLUMN + " = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, postId);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Post findOnePost(Integer postId) {
        List<Post> posts = getAllPosts();
        for (Post post : posts) {
            if (post.getPostId() == postId) {
                return post;
            }
        }
        return null;
    }
}
