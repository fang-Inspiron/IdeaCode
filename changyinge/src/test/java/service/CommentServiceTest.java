package service;

import base.BaseTest;
import dao.CollectionsDao;
import dao.CommentDao;
import entity.Collections;
import entity.SongComment;
import entity.UserComment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alber on 2016/8/31.
 */
public class CommentServiceTest extends BaseTest{
    @Autowired
    private CommentService commentService;
    @Test
    public void add() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void getUserList() throws Exception {
        List<UserComment> list=commentService.getUserList("201608310@qq.com");
        System.out.println(list);
    }

    @Test
    public void getSongList() throws Exception {
        List<SongComment> list=commentService.getSongList(10445);
        System.out.println(list);
    }

}