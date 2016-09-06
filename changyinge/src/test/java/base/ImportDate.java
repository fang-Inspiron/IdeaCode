package base;

import dao.SongDao;
import entity.Song;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by alber on 2016/8/30.
 */
public class ImportDate extends BaseTest{
    @Autowired
    private SongDao songDao;
    @Test
    public void init(){
        Song song=new Song();
        songDao.add(song);

    }
}
