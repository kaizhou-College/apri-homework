package com.kz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {

	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin://localhost:1521:orcl","scott","tiger");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeAll(ResultSet rs,Statement stmt,Connection conn){
		
		try{
			
			if(rs!=null){
				rs.close();
			}
			
			if(stmt!=null){
				stmt.close();
			}
			
			if(conn!=null){
				conn.close();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		getConn();
	}
}
