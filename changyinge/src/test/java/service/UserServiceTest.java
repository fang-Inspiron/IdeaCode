package service;

import base.BaseTest;
import entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by alber on 2016/8/31.
 */
public class UserServiceTest extends BaseTest{
    @Autowired
    private UserService userService;
    @Test
    public void register() throws Exception {
        int result=userService.register("111","111","111");
        System.out.println(result);
    }

    @Test
    public void login() throws Exception {
        int result=userService.login("111","1112");
        System.out.println(result);
    }

    @Test
    public void get() throws Exception {
        User user=userService.get("111");
        System.out.println(user);
    }

    @Test
    public void updateName() throws Exception {
        int result=userService.updateName("111","222");
        System.out.println(result);
    }

    @Test
    public void updatePassword() throws Exception {
        int result=userService.updatePassword("111","111","222");
        System.out.println(result);
    }

}