package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//得到链接和关闭链接的方法

import org.ietf.jgss.Oid;
public class BaseDao {	
	public static Connection getConn(){
		Connection conn =null;
		try {
			//链接oracle 10g
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","scott","pyj795");
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
			if(st!=null){
				st.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//测试
	public static void main(String[] args) {
		System.out.println(getConn());
	}
	
	
}
