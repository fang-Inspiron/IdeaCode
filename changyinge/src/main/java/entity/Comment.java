package entity;

import java.util.Date;

/**
 * Created by fang on 2016/9/8.
 */
public class Comment {
    private String commentId;
    private String userId;
    private String songId;
    private String Comment;
    private Date time;

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getCommentId() {
        return commentId;
    }

    public String getUserId() {
        return userId;
    }

    public String getSongId() {
        return songId;
    }

    public String getComment() {
        return Comment;
    }

    public Date getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId='" + commentId + '\'' +
                ", userId='" + userId + '\'' +
                ", songId='" + songId + '\'' +
                ", Comment='" + Comment + '\'' +
                ", time=" + time +
                '}';
    }
}
