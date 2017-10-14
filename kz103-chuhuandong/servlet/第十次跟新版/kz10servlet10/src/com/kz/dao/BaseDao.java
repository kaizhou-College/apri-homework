package com.kz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDao {
	public static Connection Getconn(){
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "orcl");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void Close(ResultSet rs,Statement st,Connection con){
		try {
			if(rs!=null){
				rs.close();
			}
			if(st!=null){
				st.close();
			}
			if(con!=null){
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
