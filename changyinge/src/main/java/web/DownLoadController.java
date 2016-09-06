package web;

import dao.DownLoadDao;
import entity.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.DownLoadService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alber on 2016/9/2.
 */
@RestController
@RequestMapping(value = "/download")
public class DownLoadController {
    @Autowired
    private DownLoadService downLoadService;
    @RequestMapping(value = "/add/{songId}")
    public Map add(HttpServletRequest request,@PathVariable("songId") Long songId){
        String userId= (String) request.getSession().getAttribute("userId");
        int result=downLoadService.add(userId,songId);
        Map response=new HashMap<String,Object>();
        if(result==0){
            response.put("result",false);
        }else{
            response.put("result",true);
        }
        return response;
    }
    @RequestMapping(value = "/delete/{songId}")
    public Map delete(HttpServletRequest request,@PathVariable("songId") Long songId){
        String userId= (String) request.getSession().getAttribute("userId");
        int result=downLoadService.delete(userId,songId);
        Map response=new HashMap<String,Object>();
        if(result==0){
            response.put("result",false);
        }else{
            response.put("result",true);
        }
        return response;
    }
    @RequestMapping(value = "/get")
    public List<Collections> get(HttpServletRequest request){
        String userId= (String) request.getSession().getAttribute("userId");
        return downLoadService.getList(userId);
    }
}
