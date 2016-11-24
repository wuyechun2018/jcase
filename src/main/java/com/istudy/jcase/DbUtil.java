package com.istudy.jcase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * 使用JDBC连接数据库
 * @desc: itools
 * @author: wyc
 * @createTime: 2016年10月24日 下午4:58:57
 * @history:
 * @version: v1.0
 */
public class DbUtil {

	public static void main(String[] args) {
		String sql="SELECT SYSDATE FROM DUAL";
		//获取当前时间
		System.out.println("The time is "+doQuery(sql));
	}

	
	/**
	 * 
	 * 获取数据库连接,进行查询
	 * @author: wyc
	 * @createTime: 2016年10月24日 下午4:54:04
	 * @history:
	 * @param sql
	 * @return int
	 */
	public static String doQuery(String sql) {
		//String url = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=172.16.7.116)(PORT=1521))(LOAD_BALANCE=yes)(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=center)(FAILOVER_MODE=(TYPE=SELECT)(METHOD=BASIC)(RETRIES=180)(DELAY=5))))";
		//String user = "center";
		//String password = "123456";
		
		//改为从配置文件database.properties中获取
		String url=PropertyConfig.getProp("database","url");
		String user=PropertyConfig.getProp("database","user");
		String password=PropertyConfig.getProp("database","password");

		String count = "";
		try {
			Connection conn = getDbConn(url, user, password);
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

			if (rs.next()) {
				//count = rs.getInt(1);
				count = rs.getString(1);
				//System.out.println(count);
			}
			rs.close();
			// 关闭连接
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 
	 * 获取oracle数据库连接
	 * @author: wyc
	 * @createTime: 2016年10月24日 下午4:54:28
	 * @history:
	 * @param url
	 * @param user
	 * @param password
	 * @return Connection
	 */
	public static Connection getDbConn(String url, String user, String password) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
