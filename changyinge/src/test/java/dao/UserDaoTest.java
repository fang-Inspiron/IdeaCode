package dao;

import entity.User;
import base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by alber on 2016/8/30.
 */
public class UserDaoTest extends BaseTest{
    @Autowired
    private UserDao userDao;
    @Test
    public void add() throws Exception {
        User user=new User();
        user.setUserId("111111");
        user.setName("111111");
        user.setPassword("111111");
        user.setPower(0);
        int result=userDao.add(user);
        System.out.println(result);
    }

    @Test
    public void delete() throws Exception {
        int result=userDao.delete("111111");
        System.out.println(result);
    }

    @Test
    public void get() throws Exception {
        User user=userDao.get("111111");
        System.out.println(user);
    }

    @Test
    public void update() throws Exception {
        User user=userDao.get("111111");
        System.out.println(user);
        user.setPower(1);
        int result=userDao.update(user);
        System.out.println(result);
    }

    @Test
    public void testGetAll() throws Exception {
        System.out.println(userDao.getAll());
    }
}