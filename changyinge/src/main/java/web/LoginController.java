package web;

import exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.ManagerService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fang on 2016/9/1.
 */
@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private ManagerService managerService;
    @RequestMapping(value = "/userlogin")
    public Map userLogin(HttpServletRequest request, String userId, String password){
        if(userId==null||password==null)
            throw new BadRequestException();
        int result=userService.login(userId,password);
        Map response=new HashMap<String,Object>();
        if(result==0){
            response.put("result",false);
            response.put("errorCode",0);                  //用户名不存在
        }else if(result==1){
            response.put("result",false);
            response.put("errorCode",1);                  //密码错误
        } else if(result==3) {
            HttpSession session=request.getSession();
            session.setAttribute("userId",userId);
            response.put("result",3);
            response.put("jsessionid",session.getId());   //管理员登录
        } else{
            HttpSession session=request.getSession();
            session.setAttribute("userId",userId);
            response.put("result",2);
            response.put("jsessionid",session.getId());   //成功登陆
        }
        return response;
    }
    @RequestMapping(value = "/userregister")
    public Map userRegister(HttpServletRequest request,String userId,String name,String password){
        if(userId==null||name==null||password==null)
            throw  new BadRequestException();
        int result=userService.register(userId,name, password);
        Map response=new HashMap<String,Object>();
        if(result==0){
            response.put("result",false);
            response.put("errorCode",0);
        }else{
            response.put("result",true);
            HttpSession session=request.getSession();
            session.setAttribute("userId",userId);
            response.put("jsessionid",session.getId());
        }
        return response;
    }
    @RequestMapping(value = "/managerlogin")
    public Map managerLogin(HttpServletRequest request,String userId,String password){
        int result=managerService.login(userId,password);
        Map response=new HashMap<String,Object>();
        if(result==0){
            response.put("result",false);
            response.put("errorCode",0);
        }else if(result==1){
            response.put("result",false);
            response.put("errorCode",1);
        }else{
            HttpSession session=request.getSession();
            session.setAttribute("userId",userId);
            session.setAttribute("power",userId);
            response.put("result",true);
            response.put("jsessionid",session.getId());
        }
        return response;
    }
}
