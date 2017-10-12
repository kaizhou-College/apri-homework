package com.wtg.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	public static final String URL="jdbc:oracle:thin://localhost:1521:orcl";
	public static final String USER="scott";
	public static final String PASSWORD="wtg123456";
	public Connection conn =null;
	public PreparedStatement pstmt = null;
	public ResultSet rs =null;
	public void getconnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("数据库连接成功");
	}
	public void closeConnection(){
		try {
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if (conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		System.out.println("数据库断开成功");
	}
}
