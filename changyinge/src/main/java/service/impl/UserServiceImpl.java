package service.impl;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

/**
 * Created by fang on 2016/8/31.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public int register(String userId,String name,String password){
        User user=userDao.get(userId);
        if(user!=null){
            return 0;                   //用户名已存在
        }else{
            User newUser=new User();
            newUser.setUserId(userId);
            newUser.setName(name);
            newUser.setPassword(password);
            newUser.setPower(0);
            userDao.add(newUser);
            return 1;                   //注册成功
        }

    }

    public int login(String userId, String password) {
        System.out.println("UserServiceImpl login.");
        User user=userDao.get(userId);
        System.out.println(user.toString());
        if(user==null) {
            System.out.println(user==null);
            return 0;   //用户不存在
        }

        if(user.getUserId().equals("1000"))
            return 3;   //管理员
        String dbPassword=user.getPassword();
        if(!dbPassword.equals(password))
            return 1;                   //密码错误
        else{
            return 2;                   //密码正确
        }
    }


    public User get(String userId) {
        return userDao.get(userId);
    }

    public int updateName(String userId, String userName) {
        User user=userDao.get(userId);
        user.setName(userName);
        return userDao.update(user);
    }

    public int updatePassword(String userId, String oldPassword, String newPassword) {
        User user=userDao.get(userId);
        String dbPassword=user.getPassword();
        if(!dbPassword.equals(oldPassword)){
            return 0;                 //密码错误
        }else{
            user.setPassword(newPassword);
            userDao.update(user);
            return 1;                 //成功修改
        }
    }
}
