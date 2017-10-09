package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Bacedao {
	public static  Connection getConn(){
		Connection conn=null;
		ResultSet rs=null;
		Statement stmt=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin://localhost:1521:orcl", "scott", "pyj795");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConn(ResultSet rs,Statement stmt,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
			if(stmt!=null){
				stmt.close();
			}
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
