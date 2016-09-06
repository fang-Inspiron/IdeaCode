package servlet;

import utils.JDBCTools;
import utils.JsonTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fang on 2016/7/20.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    public LoginServlet() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        try {
            if(isExist(request, response)) {
                if (isPwdRight(request, response)) {
                    out.println(JsonTools.createJsonString("result", "1"));//密码正确
                } else {
                    out.println(JsonTools.createJsonString("result", "0"));//密码不正确
                }
            } else {
                out.println(JsonTools.createJsonString("result", "-1"));//用户不存在
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isPwdRight(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        JDBCTools tools = new JDBCTools();
        tools.getConnection();
        String sql = "select * from user where username=? and password=?";
        List<Object> params = new ArrayList<Object>();
        params.add(username);
        params.add(password);

        return (tools.findSimpleResult(sql, params).size() > 0) ? true : false;
    }

    public boolean isExist(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String username = request.getParameter("username");
        JDBCTools tools = new JDBCTools();
        tools.getConnection();
        String sql = "select * from user where username=?";
        List<Object> params = new ArrayList<Object>();
        params.add(username);

        return (tools.findSimpleResult(sql, params).size() > 0) ? true : false;
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
