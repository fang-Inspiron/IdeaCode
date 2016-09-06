package service;

import base.BaseTest;
import dao.SongDao;
import entity.Collections;
import entity.Song;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alber on 2016/8/31.
 */
public class SongServiceTest extends BaseTest{
    @Autowired
    private SongService songService;
    @Test
    public void get() throws Exception {
        Song song=songService.get(102698215);
        System.out.println(song);
    }

    @Test
    public void increaseCollectionsCount() throws Exception {
        int result=songService.increaseCollectionsCount(102698215);
        System.out.println(result);
    }

    @Test
    public void increaseCommentCount() throws Exception {

    }

    @Test
    public void increaseDownloadCount() throws Exception {

    }

    @Test
    public void increaseHot() throws Exception {

    }

    @Test
    public void selectByHot() throws Exception {
        List<Collections> list=songService.selectByHot(0,10);
        System.out.println(list);
    }

    @Test
    public void selectByKey() throws Exception {
        List<Collections> list=songService.selectByKey("周杰伦",0,10);
        System.out.println(list);
    }

}