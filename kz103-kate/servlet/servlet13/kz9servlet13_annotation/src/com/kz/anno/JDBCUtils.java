package com.kz.anno;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtils {
	@JDBCInfo(driver="oracle.jdbc.driver.OracleDriver",
			url="jdbc:oracle:thin:@127.0.0.1:1521:orcl",
			username="scott",
			password="tiger")
	public static Connection getConn() throws Exception{
		//Class.forName(className)
		//DriverManager.getConnection(url)
		Class clazz = JDBCUtils.class;
		Method method = clazz.getMethod("getConn",null);
		if(method.isAnnotationPresent(JDBCInfo.class)){
			JDBCInfo jdbc = method.getAnnotation(JDBCInfo.class);
			String url = jdbc.url();
			String password = jdbc.password();
			String username = jdbc.username();
			String driver = jdbc.driver();
			Class.forName(driver);
			Connection conn  =DriverManager.getConnection(url,username,password);
			return conn;
		}
		return null;
	}
}
