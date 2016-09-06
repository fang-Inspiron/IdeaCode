package service;

import base.BaseTest;
import entity.Collections;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alber on 2016/8/31.
 */
public class CollectionsServiceTest extends BaseTest{
    @Autowired
    private CollectionsService collectionsService;
    @Test
    public void add() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void getList() throws Exception {
        List<Collections> list=collectionsService.getList("201608310@qq.com");
        System.out.println(list);
    }

}