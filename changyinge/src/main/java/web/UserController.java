package web;

import entity.User;
import exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alber on 2016/9/1.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/get")
    public Map get(HttpServletRequest request){
        String userId=(String)request.getSession().getAttribute("userId");
        User user=userService.get(userId);
        Map response = new HashMap<String,Object>();
        response.put("userId",user.getUserId());
        response.put("name",user.getName());
        return response;
    }
    @RequestMapping(value = "/updatename")
    public Map updateName(HttpServletRequest request,String name){
        String userId=(String)request.getSession().getAttribute("userId");
        userService.updateName(userId,name);
        Map response = new HashMap<String,Object>();
        response.put("reault",true);
        return response;
    }
    @RequestMapping(value = "updatepassword")
    public Map updatepassword(HttpServletRequest request,String oldPassword,String newPassword){
        if(oldPassword==null||newPassword==null)
            throw new BadRequestException();
        String userId=(String)request.getSession().getAttribute("userId");
        int result=userService.updatePassword(userId,oldPassword,newPassword);
        Map response=new HashMap<String,Object>();
        if(result==0){
            response.put("result",false);
            response.put("errorCode",0);           //旧密码错误
        }else{
            response.put("result",true);
        }
        return response;
    }
}
