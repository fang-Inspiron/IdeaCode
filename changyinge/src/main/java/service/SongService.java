package service;

import entity.Collections;
import entity.Song;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by alber on 2016/8/31.
 */
public interface SongService {
    public Song get(long songId);
    public int increaseCollectionsCount(long songId);
    public int increaseCommentCount(long songId);
    public int increaseDownloadCount(long songId);
    public int increaseHot(long songId);
    public List<Collections> selectByHot(int start,int rows);
    public List<Collections> selectByKey(String key,int start,int rows);
    public List<Collections> selectByCategory(String category);
    public List<Collections> getAll(int start, int rows);
}
