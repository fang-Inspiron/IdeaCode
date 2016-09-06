package service.impl;

import dao.CommentDao;
import dao.SongDao;
import entity.Song;
import entity.SongComment;
import entity.UserComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CommentService;

import java.util.List;

/**
 * Created by alber on 2016/8/31.
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private SongDao songDao;
    public int add(String userId, long songId, String comment) {
        songDao.increaseCommentCount(songId);
        return commentDao.add(userId,songId,comment);
    }

    public int delete(long commentId) {
        return commentDao.delete(commentId);
    }

    public List<UserComment> getUserList(String userId) {
        return commentDao.getUserList(userId);
    }

    public List<SongComment> getSongList(long songId) {
        return commentDao.getSongList(songId);
    }
}
