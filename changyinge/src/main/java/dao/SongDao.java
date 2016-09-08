package dao;

import entity.Collections;
import entity.Song;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by alber on 2016/8/30.
 */
public interface SongDao {
    public int add(Song song);
    public int delete(long songId);
    public Song get(long songId);
    public int increaseCollectionsCount(long songId);
    public int increaseCommentCount(long songId);
    public int increaseDownloadCount(long songId);
    public int increaseHot(long songId);
    public List<Collections> selectByHot(@Param("start") int start,@Param("rows") int rows);
    public List<Collections> selectByKey(@Param("key")String key,@Param("start")int start,@Param("rows")int rows);
    public List<Collections> selectByCategory(@Param("category")String category);
    public List<Collections> getAll(@Param("start") int start, @Param("rows") int rows);
}
