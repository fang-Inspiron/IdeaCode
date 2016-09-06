package service;

import entity.Song;
import entity.User;

/**
 * Created by alber on 2016/8/31.
 */
public interface ManagerService {
    public int login(String userId,String password);

    public User getUser(String userId);
    public int addUser(User user);
    public int updateUser(String userId,String name,String password,Integer power);
    public int deleteUser(String userId);

    public int deleteComment(long id);

    public int addSong(Song song);
    public int deleteSong(long songId);

}
