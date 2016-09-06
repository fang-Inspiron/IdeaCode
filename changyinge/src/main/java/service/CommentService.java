package service;

import entity.SongComment;
import entity.UserComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by alber on 2016/8/31.
 */
public interface CommentService {
    public int add(String userId, long songId, String comment);
    public int delete(long commentId);
    public List<UserComment> getUserList(String userId);
    public List<SongComment> getSongList(long songId);
}
