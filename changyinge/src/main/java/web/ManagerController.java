package web;

import entity.User;
import exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ManagerService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alber on 2016/9/2.
 */
@RestController
@RequestMapping(value = "/managers")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "/getuser/{userId}")
    public User getUser(@PathVariable("userId") String userId){
        return managerService.getUser(userId);
    }

    @RequestMapping(value = "/deleteuser/{userId}")
    public Map deleteUser(@PathVariable("userId") String userId){
        int result=managerService.deleteUser(userId);
        Map response=new HashMap<String,Object>();
        if(result==0){
            response.put("result",false);
        }else{
            response.put("result",true);
        }
        return response;
    }
    @RequestMapping(value = "/updateuser")
    public Map updateUser(String userId,String name,String password,Integer power){
        if(userId==null) throw new BadRequestException();
        if(name==null&&name==null&&power==null)  throw new BadRequestException();
        int result=managerService.updateUser(userId,name,password,power);
        Map response=new HashMap<String,Object>();
        if(result==0){
            response.put("result",false);      //没有找到这个用户
        }else{
            response.put("result",true);
        }
        return response;
    }
    @RequestMapping(value = "/deletecomment/{commentId}")
    public Map deleteComment(@PathVariable("commentId") Long commentId){
        int result= managerService.deleteComment(commentId);
        Map response=new HashMap<String,Object>();
        if(result==0){
            response.put("result",false);
        }else{
            response.put("result",true);
        }
        return response;
    }
    @RequestMapping(value = "/deletesong/{songId}")
    public Map deldeteSong(@PathVariable("songId") Long songId){
        int result=managerService.deleteSong(songId);
        Map response=new HashMap<String,Object>();
        if(result==0){
            response.put("result",false);
        }else{
            response.put("result",true);
        }
        return response;
    }


}
