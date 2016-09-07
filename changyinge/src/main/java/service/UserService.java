package service;

import entity.User;

import java.util.List;

/**
 * Created by alber on 2016/8/31.
 */
public interface UserService {
    public int register(String userId,String name,String password);
    public int login(String userId,String password);
    public User get(String userId);
    public List<User> getAll();
    public int updateName(String userId,String userName);
    public int updatePassword(String userId,String oldPassword,String newPassword);

}
