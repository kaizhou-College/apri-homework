package com.kz.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDao {
	public static Connection getConn(){
		Connection conn = null;
		try {
			//driver :  驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//SqlServer :jdbc:sqlserver://localhost:1433;databasename=数据名
			conn = DriverManager.getConnection("jdbc:oracle:thin://localhost:1521:orcl","scott","tiger");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConn(ResultSet rs,Statement st,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(st!=null){
				st.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		System.out.println(getConn());
	}
}
