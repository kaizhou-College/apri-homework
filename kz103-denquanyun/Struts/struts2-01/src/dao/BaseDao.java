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

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import entity.Users;
public class BaseDao<T> {
	//建立连接
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","abc");
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
	//增
	public static int add(String key,Object obj){
		//insert into 表明(字段名) values(key.nextval,字段名)
		StringBuffer sql = new StringBuffer();	
		Class clazz = obj.getClass();
		sql.append("insert into "+clazz.getSimpleName()+"(");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		sql.append(fields[0].getName()+",");
		int count=0;
		for (int i = 1; i < fields.length; i++) {
			if(fields[i]!=null){
				count++;
				sql.append(fields[i].getName()+",");
			}
		}
		String string = sql.substring(0,sql.lastIndexOf(","));
		StringBuffer sql1 = new StringBuffer(string);
		sql1.append(") values("+key+".nextval,");
		for (int i = 1; i < fields.length; i++) {
			if(fields[i]!=null){
				sql1.append("?");
				if(i<count){
					sql1.append(",");
				}
			}
		}
		sql1.append(")");
		System.out.println(sql1.toString());
		//得到链接
		Connection conn = null;
		PreparedStatement st = null;
		int num=-1;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql1.toString());
			for(int i =1;i<fields.length;i++){
				Object value = fields[i].get(obj);
				if(value instanceof Integer){
					value = ((Integer)value).intValue();
				}
				if(value ==null){
					continue;
				}
				st.setObject(i,value);
			}
			num = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, st, conn);
		}
		System.out.println(sql1.toString());
		return num;
	}
	//查
	public static List queryAll(Class clazz){
		List list =null;
		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		for (int i = 0; i < fields.length; i++) {
			sql.append(fields[i].getName());
			if(i!=fields.length-1){
				sql.append(",");
			}
		}
		sql.append(" from "+clazz.getSimpleName());
		//得到链接
		Connection conn = BaseDao.getConn();
		PreparedStatement st =null; 
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			list = new ArrayList();
			while(rs.next()){
				Object obj = clazz.newInstance();
				for (Field f : fields) {
					Object value = rs.getObject(f.getName());
					if(value instanceof BigDecimal){
						value = ((BigDecimal)value).intValue();
					}
					if(value instanceof Timestamp){
						value = ((Timestamp)value).toString();
					}
					if(value ==null){
						continue;
					}
					f.set(obj, value);
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
	//删
	public static int del(Class clazz,int id){
		StringBuffer sql = new StringBuffer();
		//delete from 表明 where id=?
		sql.append("delete from "+clazz.getSimpleName()+" where ");
		Field[] fields = clazz.getDeclaredFields();
		sql.append(fields[0].getName()+"=?");
//		System.out.println(sql.toString());
		//建立连接
		Connection conn = null;
		PreparedStatement st = null;
		int num = -1;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql.toString());
			st.setInt(1,id);
			num = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, st, conn);
		}
		return num;
	}
//	public static void main(String[] args) {
//		System.out.println(del(Users.class,4));
//	}
}
