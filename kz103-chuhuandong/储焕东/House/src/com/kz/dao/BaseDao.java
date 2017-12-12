package com.kz.dao;

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

import com.kz.entity.TBL_FWXX;
import com.kz.entity.TBL_USER;

public class BaseDao<T> {
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:orcl", "wangdapao", "dapao");
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
		}
	}
	public static int Update(Object obj,int id){
		int num = -1;
		Connection conn = BaseDao.getConn();
		Class cls = obj.getClass();
		Field[] fields = cls.getDeclaredFields();
		Field.setAccessible(fields, true);
		String sql = SqlDao.UpdateSql(fields, obj, id);
		PreparedStatement pst = null;
		System.out.println(sql);
		try {
			pst = conn.prepareStatement(sql);
			int index=1;
			for (int i = 0; i < fields.length; i++) {
				Object value=null;
				try {
					value = fields[i].get(obj);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				if(!(value instanceof Double)&&!(value instanceof Integer)){
					if(value!=null){
						pst.setObject(index,value);
						index++;
					}
				}else{
					if(value instanceof Double){
						if((Double)value!=0){
							pst.setObject(index,value);
							index++;
						}
					}else if(value instanceof Integer){
						if((Integer)value!=0){
							pst.setObject(index,value);
							index++;
						}
					}
				}
				System.out.println(value);
			}
			num = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	public static int Delete(Object obj,int id){
		int num = -1;
		Connection conn = BaseDao.getConn();
		Class cls = obj.getClass();
		Field[] fields = cls.getDeclaredFields();
		Field.setAccessible(fields, true);
		String sql = "delete from "+cls.getSimpleName()+" where "+fields[0].getName()+"=?";
		PreparedStatement pst = null;
		System.out.println(sql);
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			num = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.Close(null, pst, conn);
		}
		return num;
	}
	public List<T> SelAll(Class cls){
		List<T> list = new ArrayList<T>();
		Field[] fields = cls.getDeclaredFields();
		Field.setAccessible(fields, true);
		String sql = "select * from "+cls.getSimpleName();
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
					if(value instanceof Integer){
						value = ((Integer)value).intValue();
					}
					if(value instanceof Timestamp){
						value = ((Timestamp)value).toString();
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
	public List<T> getId(Class cls,int id){
		List<T> list = new ArrayList<T>();
		Field[] fields = cls.getDeclaredFields();
		Field.setAccessible(fields, true);
		String sql = "select * from "+cls.getSimpleName()+" where "+fields[0].getName()+"=?";
		Connection conn = BaseDao.getConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
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
					if(value instanceof Timestamp){
						value = ((Timestamp)value).toString();
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
	public static int insert(Object obj,String seq){
		int num = -1;
		Connection conn = BaseDao.getConn();
		Class cls = obj.getClass();
		Field[] fields = cls.getDeclaredFields();
		Field.setAccessible(fields, true);
		String sql = SqlDao.Sql(fields, obj, seq);
		System.out.println(sql);
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			int index=1;
			for (int i = 1; i < fields.length; i++) {
				Object value=null;
				try {
					value = fields[i].get(obj);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				if(!(value instanceof Double)&&!(value instanceof Integer)){
					if(value!=null){
//						System.out.println(sql+"index=="+index+"value=="+value);
						pst.setObject(index,value);
						index++;
					}
				}else{
					if(value instanceof Double){
						if((Double)value!=0){
							pst.setObject(index,value);
							index++;
						}
					}else if(value instanceof Integer){
						if((Integer)value!=0){
							pst.setObject(index,value);
							index++;
						}
					}
				}
			}
			num = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	public static void main(String[] args) {
		System.out.println(new BaseDao().getUser(TBL_USER.class, "wangdapao"));
	}
}
