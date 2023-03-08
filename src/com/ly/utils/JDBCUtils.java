package com.ly.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//建立数据库连接的工具类
public class JDBCUtils {
	private JDBCUtils() {
	}
	private static String url=null;
	private static String username=null;
	private static String password=null;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			url="jdbc:mysql://localhost:3306/workers?useUnicode=true&characterEncoding=UTF-8";
			username="root";
			password="123456";
			
		}catch(Exception e) {
			throw new RuntimeException(e+"数据库无法加载驱动");
		}
	}
	
	public static Connection getConnection() {
		Connection con=null;
		try {
			if(con==null) {
				con=DriverManager.getConnection(url,username,password);
		}
		return con;
	}catch (Exception e) {
		throw new RuntimeException(e+"数据库连接失败");
	}
  }
	public static void close(ResultSet rs,PreparedStatement pre,Connection con) {
		if(rs!=null) {
			try {
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}

			if(pre!=null) {
				try {
					pre.close();
				}catch(SQLException e){
					e.printStackTrace();
				}			
			}
			if(con!=null) {
				try {
					con.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
	
		}
	}
}
