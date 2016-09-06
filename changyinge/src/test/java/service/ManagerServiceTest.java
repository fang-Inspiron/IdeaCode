package service;

import base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by alber on 2016/8/31.
 */
public class ManagerServiceTest extends BaseTest{
    @Autowired
    private ManagerService managerService;
    @Test
    public void login() throws Exception {
        int result=managerService.login("111","22");
        System.out.println(result);
    }

    @Test
    public void addUser() throws Exception {

    }

    @Test
    public void updateUser() throws Exception {

    }

    @Test
    public void deleteUser() throws Exception {

    }

    @Test
    public void deleteComment() throws Exception {

    }

    @Test
    public void addSong() throws Exception {

    }

    @Test
    public void deleteSong() throws Exception {

    }

}