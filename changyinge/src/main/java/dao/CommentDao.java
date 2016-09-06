package dao;

import entity.SongComment;
import entity.UserComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by alber on 2016/8/30.
 */
public interface CommentDao {
    public int add(@Param("userId")String userId,@Param("songId")long songId,@Param("comment")String comment);
    public int delete(long commentId);
    public List<UserComment> getUserList(String userId);
    public List<SongComment> getSongList(long songId);
}
