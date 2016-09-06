package web;

import entity.UserComment;
import exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.CommentService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alber on 2016/9/1.
 */
@RestController
@RequestMapping(value = "/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Map add(HttpServletRequest request,Long songId,String comment){
        if(songId==null||comment==null){
            throw new BadRequestException();
        }
        String userId= (String) request.getSession().getAttribute("userId");
        int result=commentService.add(userId,songId,comment);
        Map response=new HashMap<String,Object>();
        if(result==0){
            response.put("result",false);
        }else{
            response.put("result",true);
        }
        return response;
    }
    @RequestMapping(value = "/delete/{commentId}",method = RequestMethod.POST)
    public Map delete(@PathVariable("commentId") Long commentId){
        int result=commentService.delete(commentId);
        Map response=new HashMap<String,Object>();
        if(result==0){
            response.put("result",false);
        }else{
            response.put("result",true);
        }
        return response;
    }
    @RequestMapping(value = "/get")
    public List<UserComment> get(HttpServletRequest request){
        String userId= (String) request.getSession().getAttribute("userId");
        return commentService.getUserList(userId);
    }
}
