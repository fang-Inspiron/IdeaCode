package dao;

import base.BaseTest;
import com.fasterxml.jackson.databind.deser.Deserializers;
import entity.SongComment;
import entity.UserComment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alber on 2016/8/30.
 */
public class CommentDaoTest extends BaseTest{

    @Autowired
    private CommentDao commentDao;
    @Test
    public void add() throws Exception {
        int result=commentDao.add("111111",111,"还不错");
        System.out.println(result);
    }

    @Test
    public void delete() throws Exception {
        int result=commentDao.delete(7);
        System.out.println(result);
    }

    @Test
    public void getUserList() throws Exception {
        List<UserComment> list=commentDao.getUserList("111111");
        System.out.println(list);

    }

    @Test
    public void getSongList() throws Exception {
        List<SongComment> list= commentDao.getSongList(111);
        System.out.println(list);
    }


}