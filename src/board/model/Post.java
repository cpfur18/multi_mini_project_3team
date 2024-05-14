package board.model;

import java.time.LocalDate;
import java.util.Date;

public class Post {
    private final int postId;
    private final LocalDate date;
    private final String title;
    private final String content;
    private final int memberNo;

    public Post(int postId, LocalDate date, String title, String content, int memberNo) {
        this.postId = postId;
        this.date = date;
        this.title = title;
        this.content = content;
        this.memberNo = memberNo;
    }

    public int getPostId() {
        return postId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getMemberNo() {
        return memberNo;
    }
}
