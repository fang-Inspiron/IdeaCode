package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTools {

	private final String USERNAME = "root";
	private final String PASSWORD = "root";
	private final String URL = "jdbc:mysql://localhost:3306/offlinecache";
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private Connection connection;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	private File file = null;

	public JDBCTools() {
		try {
			Class.forName(DRIVER);
			System.out.println("注册驱动成功!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("注册驱动异常!");
		}
	}

	// 查询单条记录
	public Map<String, Object> findSimpleResult(String sql, List<Object> params)
			throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		int index = 1;
		preparedStatement = connection.prepareStatement(sql);
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				preparedStatement.setObject(index++, params.get(i));
			}
		}
		resultSet = preparedStatement.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int col_len = metaData.getColumnCount();
		while (resultSet.next()) {
			for (int i = 0; i < col_len; i++) {
				String col_name = metaData.getColumnName(i + 1);
				Object col_value = resultSet.getObject(col_name);
				if (col_value == null) {
					col_value = "";
				}
				map.put(col_name, col_value);
			}
		}
		return map;
	}

	public <T> T findSimpleRefResult(String sql, List<Object> params,
									 Class<T> cls) throws Exception {
		T resultObject = null;
		int index = 1;
		preparedStatement = connection.prepareStatement(sql);
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				preparedStatement.setObject(index++, params.get(i));
			}
		}
		resultSet = preparedStatement.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int col_len = metaData.getColumnCount();
		while (resultSet.next()) {
			resultObject = cls.newInstance();
			for (int i = 0; i < col_len; i++) {
				String col_name = metaData.getColumnName(i + 1);
				Object col_value = resultSet.getObject(col_name);
				if (col_value == null) {
					col_value = "";
				}
				Field field = cls.getDeclaredField(col_name);
				field.setAccessible(true);// 打开javabean的private权限
				field.set(resultObject, col_value);
			}
		}
		return resultObject;
	}

	public <T> List<T> findMoreRefResult(String sql, List<Object> params,
										 Class<T> cls) throws Exception {
		List<T> list = new ArrayList<T>();
		int index = 1;
		preparedStatement = connection.prepareStatement(sql);
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				preparedStatement.setObject(index++, params.get(i));
			}
		}
		resultSet = preparedStatement.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int col_len = metaData.getColumnCount();
		while (resultSet.next()) {
			T object = cls.newInstance();
			for (int i = 0; i < col_len; i++) {
				String col_name = metaData.getColumnName(i + 1);
				Object col_value = resultSet.getObject(col_name);
				if (col_value == null) {
					col_value = "";
				}
				Field field = cls.getDeclaredField(col_name);
				field.setAccessible(true);// 打开javabean的private权限
				field.set(object, col_value);
			}
			list.add(object);
		}
		return list;
	}

	// 查询多条记录
	public List<Map<String, Object>> findMoreResult(String sql,
													List<Object> params) throws SQLException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int index = 1;
		preparedStatement = connection.prepareStatement(sql);
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				preparedStatement.setObject(index++, params.get(i));
			}
		}
		resultSet = preparedStatement.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int col_len = metaData.getColumnCount();
		while (resultSet.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			for (int i = 0; i < col_len; i++) {
				String col_name = metaData.getColumnName(i + 1);
				Object col_value = resultSet.getObject(col_name);
				if (col_value == null) {
					col_value = "";
				}
				map.put(col_name, col_value);
			}
			list.add(map);
		}
		return list;
	}

	public boolean deleteSimple(String sql, List<Object> params)
			throws SQLException {
		boolean flag;
		int result = -1;
		preparedStatement = connection.prepareStatement(sql);
		int index = 1;
		preparedStatement.setString(index, (String) params.get(0));
		result = preparedStatement.executeUpdate();
		flag = result > 0 ? true : false;
		return flag;
	}

	public Connection getConnection() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR");
		}
		return connection;
	}

	public boolean updateByPreparedStatement(String sql, List<Object> params)
			throws SQLException {
		boolean flag;
		int result = -1; // 执行SQL语句影响数据库的行数
		preparedStatement = connection.prepareStatement(sql);
		int index = 1;
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				preparedStatement.setObject(index++, params.get(i));
			}
		}
		result = preparedStatement.executeUpdate();
		flag = result > 0 ? true : false;
		return flag;
	}
	/**
	 ** 向数据库中插入一个新的BLOB对象(图片) 　　
	 ** @param fileName 要输入的数据文件 　
	 *@param id 图片id　
	 ** @throws
	 * Exception 　　
	 */
	public boolean blobInsert(String id,String fileName) throws Exception {
		FileInputStream fis = null;
		try {
			file = new File(fileName);
			fis = new FileInputStream(file);
			preparedStatement = connection.prepareStatement("insert into stuinfo(id,headurl,headphoto) values(?,?,?)");
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, file.getName());
			preparedStatement.setBinaryStream(3, fis, fis.available()); // 第二个参数为文件的内容
			preparedStatement.executeUpdate();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
			// 关闭所打开的对像//
			fis.close();
		}
	}

	/**
	 * 　　* 从数据库中读出BLOB对象 　　
	 * * @param outfile 输出的数据文件 　　
	 * * @param picID
	 * 要取的图片在数据库中的ID 　　
	 * * @throws java.lang.Exception 　　
	 */
	public String blobRead(String outfile, String id) throws Exception {
		FileOutputStream fos = null;
		InputStream is = null;
		byte[] Buffer = new byte[4096];
		try {
			preparedStatement = connection
					.prepareStatement("select headphoto from stuinfo where id=?");
			preparedStatement.setString(1, id); // 传入要取的图片的ID
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			file = new File(outfile);
			if (!file.exists()) {
				file.createNewFile(); // 如果文件不存在，则创建
			}
			fos = new FileOutputStream(file);
			is = resultSet.getBinaryStream("headphoto");
			int size = 0;
			while ((size = is.read(Buffer)) != -1) {
				fos.write(Buffer, 0, size);
			}
			return outfile.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			fos.close();
			resultSet.close();
			preparedStatement.close();
			connection.close();
		}
	}
}
