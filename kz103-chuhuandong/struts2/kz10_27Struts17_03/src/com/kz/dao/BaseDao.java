package com.kz.dao;

import com.kz.entity.Users;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kz.entity.orders;

public class BaseDao<T> {
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "orcl");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void Close(ResultSet rs,Statement pst,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
			if(pst!=null){
				pst.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
//	select * from users where username='Íõ´óÅÚ'
	public List<T> getUser(Class cls,String name){
		List<T> list = new ArrayList<T>();
		Field[] fields = cls.getDeclaredFields();
		Field.setAccessible(fields, true);
		String sql = "select * from "+cls.getSimpleName()+" where "+fields[1].getName()+"=?";
		Connection conn = BaseDao.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			rs = pst.executeQuery();
			while(rs.next()){
				T t=null;
				try {
					t = (T) cls.newInstance();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (int i = 0; i < fields.length; i++) {
					Object value = rs.getObject(fields[i].getName());
					if(value instanceof BigDecimal){
						value = ((BigDecimal)value).intValue();
					}
					try {
						fields[i].set(t, value);
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<T> getUsers(Class cls){
		List<T> list = new ArrayList<T>();
		Field[] fields = cls.getDeclaredFields();
		Field.setAccessible(fields, true);
		String sql = "select * from "+cls.getSimpleName()+" order by orderdate desc";
		Connection conn = BaseDao.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				T t=null;
				try {
					t = (T) cls.newInstance();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (int i = 0; i < fields.length; i++) {
					Object value = rs.getObject(fields[i].getName());
					if(value instanceof BigDecimal){
						value = ((BigDecimal)value).intValue();
					}
					try {
						fields[i].set(t, value);
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args) {
		Class cls = orders.class;
		System.out.println(new BaseDao().getUsers(cls));
	}
	public static int insert(String seq,Object obj){
		int num=-1;
		StringBuffer sql=new StringBuffer("insert into ");
		Class clazz=obj.getClass();
		Field[] fields=clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		sql.append(clazz.getSimpleName());
		sql.append(" values("+seq+".nextval,");
		for (int i = 1; i < fields.length; i++) {
			sql.append("?");
			if(i!=fields.length-1){
				sql.append(",");
			}
		}
		sql.append(")");
		System.out.println(sql.toString());
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=BaseDao.getConn();
			st=conn.prepareStatement(sql.toString());
			for (int i = 1; i < fields.length; i++) {
				Object value=fields[i].get(obj);
				st.setObject(i, value);
			}
			num=st.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			BaseDao.Close(null, st, conn);
		}
		return num;
	}
}
