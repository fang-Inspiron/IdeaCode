package entity;

import java.util.Date;

/**
 * Created by alber on 2016/8/31.
 */
public class SongComment {
    private long commentId;
    private String userId;
    private String name;
    private String comment;
    private Date time;

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "SongComment{" +
                "commentId=" + commentId +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", time=" + time +
                '}'+"\n";
    }
}
