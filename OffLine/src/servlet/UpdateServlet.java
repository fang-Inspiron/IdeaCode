package servlet;

import bean.User;
import utils.DBUtils;
import utils.JsonTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by fang on 2016/7/21.
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setLinks(request.getParameter("links"));

        try {
            boolean flag = DBUtils.modify(request.getParameter("username"), user);
            if (flag) {
                out.println(JsonTools.createJsonString("result", "1"));
            } else {
                out.println(JsonTools.createJsonString("result", "0"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
