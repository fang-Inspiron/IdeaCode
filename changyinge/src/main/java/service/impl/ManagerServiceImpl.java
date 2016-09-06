package service.impl;

import dao.CommentDao;
import dao.SongDao;
import dao.UserDao;
import entity.Song;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ManagerService;

/**
 * Created by alber on 2016/8/31.
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private SongDao songDao;
    @Autowired
    private CommentDao commentDao;

    public int login(String userId, String password) {
        User user=userDao.get(userId);
        if(user==null)
            return 0;                     //用户不存在
        else{
            if(user.getPower()!=1)
                return 0;                 //用户不存在
            else{
                if(!user.getPassword().equals(password))
                    return 1;             //密码错误
                else{
                    return 2;             //验证成功
                }
            }
        }

    }

    public User getUser(String userId){
        return userDao.get(userId);
    }

    public int addUser(User user) {
        return userDao.add(user);
    }

    public int updateUser(String userId,String name,String password,Integer power) {
        User user=userDao.get(userId);
        if(user==null)
            return 0;
        if(name!=null)
            user.setName(name);
        if(password!=null)
            user.setPassword(password);
        if(power!=null)
            user.setPower(power);
        return userDao.update(user);
    }

    public int deleteUser(String userId) {
        return userDao.delete(userId);
    }

    public int deleteComment(long commentId) {
        return commentDao.delete(commentId);
    }

    public int addSong(Song song) {
        return songDao.add(song);
    }

    public int deleteSong(long songId) {
        return songDao.delete(songId);
    }
}
