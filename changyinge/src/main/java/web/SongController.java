package web;

import entity.*;
import exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CommentService;
import service.SongService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by alber on 2016/9/1.
 */
@RestController
@RequestMapping(value = "/song")
public class SongController {
    @Autowired
    private SongService songService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/get/{songId}")
    public Song get(@PathVariable("songId") Long songId){
        Song song= songService.get(songId);
        if(song==null){
            throw new BadRequestException();
        }else{
            return song;
        }
    }
    @RequestMapping(value = "/increasedownloadcount/{songId}")
    public Map increaseDownloadCount(@PathVariable("songId") long songId) {
        int result=songService.increaseDownloadCount(songId);
        Map response=new HashMap<String,Object>();
        if(result==0){
            response.put("result",false);
        }else{
            response.put("result",true);
        }
        return response;
    }
    @RequestMapping(value = "/increasehot/{songId}")
    public Map increaseHot(@PathVariable("songId")long songId) {
        int result=songService.increaseHot(songId);
        Map response=new HashMap<String,Object>();
        if(result==0){
            response.put("result",false);
        }else{
            response.put("result",true);
        }
        return response;
    }
    @RequestMapping(value = "/selectbyhot/{start}/{rows}")
    public List<Collections> selectByHot(@PathVariable("start") int start,@PathVariable("rows") int rows) {
        return songService.selectByHot(start,rows);
    }
    @RequestMapping(value = "/selectbykey/{key}/{start}/{rows}")
    public List<Collections> selectByKey(@PathVariable("key")String key,@PathVariable("start") int start,@PathVariable("rows")int rows) {
        return songService.selectByKey(key,start,rows);
    }
    @RequestMapping(value = "/selectbycategory/{category}")
    public List<Collections> selectByCategory(@PathVariable("category") String category) {
        return songService.selectByCategory(category);
    }
    @RequestMapping(value = "/getsongcomment/{songId}")
    public List<SongComment> getSongComment(@PathVariable("songId") Long songId){
        return commentService.getSongList(songId);
    }

    @RequestMapping(value = "/getAllUser")
    public List<User> getAllUser(){
        List<User> list = userService.getAll();
        return list;
    }

    @RequestMapping(value = "/getSomeSong/{start}/{rows}")
    public List<Collections> getAllSong(@PathVariable("start") int start,@PathVariable("rows") int rows) {
        return songService.getAll(start, rows);
    }

    @RequestMapping(value = "/getAllComment")
    public List<Comment> getAllComment(HttpServletRequest request) {
        return commentService.getAllComment();
    }
}
