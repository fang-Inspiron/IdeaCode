package dao;

import base.BaseTest;
import entity.Collections;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alber on 2016/8/30.
 */
public class DownLoadDaoTest extends BaseTest{

    @Autowired
    private DownLoadDao downLoadDao;
    @Test
    public void add() throws Exception {
        int result=downLoadDao.add("111111",111);
        System.out.println(result);
    }

    @Test
    public void delete() throws Exception {
        int result=downLoadDao.delete("111111",111);
        System.out.println(result);
    }

    @Test
    public void getList() throws Exception {
        List<Collections> list=downLoadDao.getList("111111");
        System.out.println(list);
    }

}