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

import com.kz.entity.City;
import com.kz.entity.District;



public class BaseDao {
	//连接数据库
	public static Connection getConn(){
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "turing", "turing");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	//断开数据库
	public static void closeConn(ResultSet rs,Statement st, Connection conn){
		try {
			if (rs!=null) {
				rs.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			if (st!=null) {
				st.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			if (conn!=null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//查询select * from 表
	public <T> List<T> query(Class clazz){
		List<T> list=null;
		StringBuffer sql=new StringBuffer("select ");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		for (int i = 0; i < fields.length; i++) {
			String name = fields[i].getName();
			sql.append(name);
			if (i!=fields.length-1) {
				sql.append(",");
			}
			
		}
		sql.append(" from "+clazz.getSimpleName());
		
		System.out.println(sql.toString());
		Connection conn = getConn();
		PreparedStatement st =null;
		ResultSet rs = null;
		list=new ArrayList<T>();
		try {
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			while (rs.next()) {
				T t= (T) clazz.newInstance();
				for (int i = 0; i < fields.length; i++) {
					Object value = rs.getObject(fields[i].getName());
					if (value instanceof BigDecimal) {
						value=((BigDecimal)value).intValue();
					}
					fields[i].set(t, value);
					
				}
				list.add(t);
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
		}
		return list;
	}
	//删除delete from 表名  where 列名=?
	public int remove(int id,Class clazz){
		int num=-1;
		StringBuffer sql=new StringBuffer("delete from "+clazz.getSimpleName()+" where ");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		sql.append(fields[0].getName()+"=?");
		System.out.println(sql.toString());
		Connection conn = getConn();
		PreparedStatement st =null;
		try {
			st=conn.prepareStatement(sql.toString());
			st.setInt(1, id);
			num = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	//查询某个类单个数据的方法
	public <T> List<T> load(Class c,int id) throws InstantiationException, IllegalAccessException {
		List<T> list=null;
		StringBuffer sql=new StringBuffer("select ");
		//得到所有的属性
		Field[] fields = c.getDeclaredFields();
		Field.setAccessible(fields, true);
		//把需要的属性拼接到sql上并且用，号隔开
		for (int i = 0; i < fields.length; i++) {
			sql.append(fields[i].getName());
			if (i!=fields.length-1) {
				sql.append(",");
			}
		}
		sql.append(" from "+c.getSimpleName()+" where "+fields[2].getName()+"=?");
		System.out.println(sql.toString()); 
		//连接数据库
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		try {
			conn = BaseDao.getConn();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setObject(1, id);	
			rs = pstmt.executeQuery();
			list=new ArrayList<T>();
			while(rs.next()){
				 T t = (T) c.newInstance();
				for (Field field : fields) {
					Object value = rs.getObject(field.getName());
					if (value instanceof BigDecimal) {
						value=((BigDecimal)value).intValue();
					}
					field.set(t, value);
				}
				list.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConn(rs, pstmt, conn);
		}
		
		
		return list;
	}
	
	public static void main(String[] args) {
		//System.out.println(BaseDao.getConn());
		BaseDao basedao=new BaseDao();
		
		try {
			System.out.println(basedao.load(District.class, 1));
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
