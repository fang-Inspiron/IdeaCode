package dao;

import base.BaseTest;
import entity.Collections;
import entity.Song;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by alber on 2016/8/30.
 */
public class SongDaoTest extends BaseTest{

    @Autowired
    private SongDao songDao;
    @Test
    public void add() throws Exception {
        Song song=new Song();
        song.setSongId(222);
        song.setSongName("222");
        song.setSinggerName("222");
        song.setAlbumName("222");
        song.setAlbumpicBig("222");
        song.setAlbumpicSma("222");
        song.setDownurl("222");
        song.setM4a("222");
        song.setSeconds(222);
        song.setCategory("222");
        song.setLrc("222");
        int result=songDao.add(song);
        System.out.println(result);
    }

    @Test
    public void delete() throws Exception {
        int result=songDao.delete(111);
        System.out.println(result);
    }

    @Test
    public void get() throws Exception {
        Song song=songDao.get(107693524);
        System.out.println(song);
    }

    @Test
    public void increaseCollectionsCount() throws Exception {
        int result=songDao.increaseCollectionsCount(111);
        System.out.println(result);
    }

    @Test
    public void increaseCommentCount() throws Exception {
        int result=songDao.increaseCommentCount(111);
        System.out.println(result);
    }

    @Test
    public void increaseDownloadCount() throws Exception {
        int result=songDao.increaseDownloadCount(111);
        System.out.println(result);
    }

    @Test
    public void increaseHot() throws Exception {
        int result=songDao.increaseHot(111);
        System.out.println(result);
    }
    @Test
    public void selectByHot() throws Exception {
        List<Collections> list=songDao.selectByHot(0,10);
        System.out.println(list);
    }

    @Test
    public void selectByKey() throws Exception {
        List<Collections> list=songDao.selectByKey("%薛之谦%",0,10);
        System.out.println(list);
    }

    @Test
    public void selectByCategory() throws Exception {
        List<Collections> list=songDao.selectByCategory("1");
        System.out.println(list);
    }

}