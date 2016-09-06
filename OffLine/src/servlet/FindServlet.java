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
 * Created by fang on 2016/7/25.
 */
@WebServlet("/FindServlet")
public class FindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        try {
            User user = DBUtils.findOneUser(request.getParameter("username"));
            user.getLinks();
            int size = 0;
            for (int i=0; i<user.getLinks().length(); i++) {
                char c=user.getLinks().charAt(i);
                if (c==',')
                    size++;
            }
            out.println(JsonTools.createJsonString("result", size));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
