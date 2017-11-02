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
import java.util.Date;
import java.util.List;

import entity.Orders;
import entity.Users;

public class BaseDao {
	//建立连接
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:127.0.0.1:1521:orcl","scott","abc");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	//关闭连接
	public static void closeConn(ResultSet rs,Statement st,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(st!=null){
				st.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//查询所有
	public static List queryAll(Class clazz){
		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		for (int i = 0; i < fields.length; i++) {
			sql.append(fields[i].getName());
			
			if(i<fields.length-1){
				sql.append(",");
			}
		}
		sql.append(" from "+clazz.getSimpleName());
		System.out.println(sql.toString());
		//建立连接
		List list = new ArrayList(0);
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs =null;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			while(rs.next()){
				Object obj = clazz.newInstance();
				for (int i = 0; i < fields.length; i++) {
					Object value = rs.getObject(fields[i].getName());
					if(value instanceof BigDecimal){
						value = ((BigDecimal)value).intValue();
					}
					if(value instanceof Timestamp){
						value = ((Timestamp)value).toString();
					}
					fields[i].set(obj, value);
				}
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return list;
	}
	//登陆验证
	public static String loginQuery(String name,String pwd){
		String sql = "select * from Users where uname=? and upassword=?";
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			 conn = BaseDao.getConn();
			 st = conn.prepareStatement(sql);
			 st.setString(1,name);
			 st.setString(2,pwd);
			 rs = st.executeQuery();
			 if(rs.next()){
				 return "已有";
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return "没有";
	}
	//根据id删除
	public static int delete(Class clazz,int id){
		//delete from 表明   where id=？
		StringBuffer sql = new StringBuffer();
		sql.append("delete from "+clazz.getSimpleName()+" where ");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		sql.append(fields[0].getName());
		sql.append("="+id);
		Connection conn = null;
		PreparedStatement st =null;
		int num =-1;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql.toString());
			num = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, st, conn);
		}
		return num;
	}

	public static int update(Object obj,int id){
		//update 表明 set 字段名=？,字段名=？ where id =?
		StringBuffer sql = new StringBuffer();
		Class clazz = obj.getClass();
		sql.append("update "+clazz.getSimpleName()+" set ");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		int count=0;
		for (int i = 1; i < fields.length; i++) {
			try {
				if(fields[i].get(obj)!=null){
					count++;
					sql.append(fields[i].getName()+"=?,");
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(count);
		String sql2 = sql.substring(0,sql.length()-1);
		StringBuffer sql1 = new StringBuffer(sql2);
		sql1.append(" where "+fields[0].getName()+"="+id);
		Connection conn = null;
		PreparedStatement st = null;
		int num = -1;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql1.toString());
			for (int i = 1; i < fields.length; i++) {
				try {
					if(fields[i].get(obj)!=null){
						for (int j = 1; j <= count; j++) {
							st.setObject(j,fields[i].get(obj));
						}
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			num = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, st, conn);
		}
		return num;
	}
	public static void main(String[] args) {
		//查询测试
//		List list = queryAll(Users.class);
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//		登陆测试
//		String query = loginQuery("s","323456");
//		System.out.println(query);
		//删除测试
//		System.out.println(delete(Users.class,2));
		//修改测试
//		Users u = new Users();
//		u.setUpassword("IloveU");
//		System.out.println(update(u,5));
//		Date date = new Date();
//		Timestamp time = new Timestamp(date.getTime());
//		System.out.println(time);
	}
}
