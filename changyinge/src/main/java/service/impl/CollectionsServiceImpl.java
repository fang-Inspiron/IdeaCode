package service.impl;

import dao.CollectionsDao;
import dao.SongDao;
import entity.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CollectionsService;

import java.util.List;

/**
 * Created by alber on 2016/8/31.
 */
@Service
public class CollectionsServiceImpl implements CollectionsService {
    @Autowired
    private CollectionsDao collectionsDao;
    @Autowired
    private SongDao songDao;
    public int add(String userId, long songId) {
        songDao.increaseCollectionsCount(songId);
        int result=collectionsDao.add(userId,songId);
        return result;
    }

    public int delete(String userId, long songId) {
        return collectionsDao.delete(userId,songId);
    }

    public List<Collections> getList(String userId) {
        return collectionsDao.getList(userId);
    }
}
