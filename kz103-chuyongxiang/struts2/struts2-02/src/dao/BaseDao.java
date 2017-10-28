package dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseDao {
	public static Connection getConn(){
		Connection conn =null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl1","scott","orcl");
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	测试连接
//	public static void main(String[] args) {
//		System.out.println(getConn());
//	}
	//查询验证
	public static boolean select(String name,String pwd){
		String sql = "select * from users where name=? and pwd=?";
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs =null;
		
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql);
			st.setString(1,name);
			st.setString(2,pwd);
			rs = st.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return false;
	}
//	public static void main(String[] args) {
//		System.out.println(select("sa","er"));
//	}
}