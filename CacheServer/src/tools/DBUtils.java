package tools;

import bean.User;

import java.util.ArrayList;
import java.util.List;


public class DBUtils {
	
	public static boolean insert(User user) throws Exception {
		JDBCTools jUtils = new JDBCTools();
		jUtils.getConnection();
		
		String sql = "insert into user values(?,?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUsername());
		params.add(user.getPassword());
		params.add(user.getLinks());
		System.out.println(user);
		
		return jUtils.updateByPreparedStatement(sql, params);
	}
	
	public static boolean deleteUser(String username) throws Exception {
		JDBCTools JDBCTools = new JDBCTools();
		JDBCTools.getConnection();
		
		String sql = "delete from user where username=?";
		List<Object> params = new ArrayList<Object>();
		params.add(username);
		return JDBCTools.updateByPreparedStatement(sql, params);
	}
	
	public static boolean modify(String username, User user) throws Exception {
		JDBCTools JDBCTools = new JDBCTools();
		JDBCTools.getConnection();
		
		String sql = "update user set username=?, password=?, links=? where username=?";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUsername());//add次序要和sql语句的“？”的参数顺序保持一致
		params.add(user.getPassword());
		params.add(user.getLinks());
		params.add(username);
		return JDBCTools.updateByPreparedStatement(sql, params);
	}
	
	public static User findOneUser(String username) throws Exception {
		JDBCTools JDBCTools = new JDBCTools();
		JDBCTools.getConnection();
		
		String sql = "select * from user where username=?";
		List<Object> params = new ArrayList<Object>();
		params.add(username);
		return JDBCTools.findSimpleRefResult(sql, params, User.class);
	}
	
	public static List<User> findAllUser() throws Exception {
		JDBCTools JDBCTools = new JDBCTools();
		JDBCTools.getConnection();
		
		String sql = "select * from user";
		return JDBCTools.findMoreRefResult(sql, null, User.class);
	}
	
}
