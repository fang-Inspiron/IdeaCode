package dao;

import entity.Collections;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by alber on 2016/8/30.
 */
public interface CollectionsDao {
    public int add(@Param("userId") String userId, @Param("songId") long songId);
    public int delete(@Param("userId") String userId, @Param("songId") long songId);
    public List<Collections> getList(String userId);
}
