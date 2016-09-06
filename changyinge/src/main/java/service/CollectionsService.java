package service;

import entity.Collections;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by alber on 2016/8/31.
 */
public interface CollectionsService {
    public int add(String userId, long songId);
    public int delete(String userId, long songId);
    public List<Collections> getList(String userId);
}
