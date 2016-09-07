package service.impl;

import dao.SongDao;
import entity.Collections;
import entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.SongService;

import java.util.List;

/**
 * Created by alber on 2016/8/31.
 */
@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongDao songDao;

    public Song get(long songId) {
        return songDao.get(songId);
    }

    public int increaseCollectionsCount(long songId) {
        return songDao.increaseCollectionsCount(songId);
    }

    public int increaseCommentCount(long songId) {
        return songDao.increaseCommentCount(songId);
    }

    public int increaseDownloadCount(long songId) {
        return songDao.increaseDownloadCount(songId);
    }

    public int increaseHot(long songId) {
        return songDao.increaseHot(songId);
    }

    public List<Collections> selectByHot(int start,int rows) {
        return songDao.selectByHot(start,rows);
    }

    public List<Collections> selectByKey(String key, int start,int rows) {
        return songDao.selectByKey("%"+key+"%",start,rows);
    }
    public List<Collections> selectByCategory(String category){
        return songDao.selectByCategory(category);
    }
}
