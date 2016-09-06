package service.impl;

import dao.DownLoadDao;
import dao.SongDao;
import entity.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.DownLoadService;
import service.SongService;

import java.util.List;

/**
 * Created by alber on 2016/8/31.
 */
@Service
public class DownLoadServiceImpl implements DownLoadService {
    @Autowired
    private DownLoadDao downLoadDao;
    @Autowired
    private SongDao songDao;
    public int add(String userId, long songId) {
        songDao.increaseDownloadCount(songId);
        return downLoadDao.add(userId,songId);
    }

    public int delete(String userId, long songId) {
        return downLoadDao.delete(userId,songId);
    }

    public List<Collections> getList(String userId) {
        return downLoadDao.getList(userId);

    }
}
