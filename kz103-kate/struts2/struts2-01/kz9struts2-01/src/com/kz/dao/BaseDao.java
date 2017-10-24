package com.kz.dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseDao<T> {
	/**
	 * 1,配置Tomcat/conf/context.xml
	 * 2,配置工程的web.xml
	 * 3,拷贝驱动包到Tomcat/lib下
	 * @return
	 * @throws NamingException 
	 */
	public static Connection getConn() {
		Connection conn = null;
		//要求连接池
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/conn/oracle");
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConn(ResultSet rs,Statement st,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(st!=null){
				st.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null){
				conn.close();//使用连接池技术 不是真正的关闭，放回连接池
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * select 字段1，字段2 from 表名
	 */
	public  List<T> queryData(Class<T> clazz){
		ArrayList<T> list = null;
		StringBuffer sql = new StringBuffer("select ");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		for(int i=0;i<fields.length;i++){
			sql.append(fields[i].getName());
			if(i!=fields.length-1){
				sql.append(", ");
			}
		}
		sql.append(" from "+clazz.getSimpleName());
		System.out.println(sql.toString());
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			list = new ArrayList<T>();
			while(rs.next()){
				T t = clazz.newInstance();
				for(int i=0;i<fields.length;i++){
					Object value = rs.getObject(fields[i].getName());
					if(value instanceof BigDecimal){
						value = ((BigDecimal)value).intValue();
					}
					fields[i].set(t, value);
				
				}
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return list;
	}
	//分页查询
	/**
	 * select * from
	 * (select rownum rn ,t.* from message t)
	 * where rn>(page-1)*pageSize and rn<=page*pageSize
	 */
	public  List<T> queryDataPage(Class<T> clazz,int page,int pageSize){
		ArrayList<T> list = null;
		StringBuffer sql = new StringBuffer("select ");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		for(int i=0;i<fields.length;i++){
			sql.append(fields[i].getName());
			if(i!=fields.length-1){
				sql.append(", ");
			}
		}
		
		sql.append(" from (select rownum rn ,t.* from "+clazz.getSimpleName()+" t) ");
		sql.append(" where rn> "+(page-1)*pageSize);
		sql.append(" and rn<= "+page*pageSize);
		System.out.println(sql.toString());
		
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			list = new ArrayList<T>();
			while(rs.next()){
				T t = clazz.newInstance();
				for(int i=0;i<fields.length;i++){
					Object value = rs.getObject(fields[i].getName());
					if(value instanceof BigDecimal){
						value = ((BigDecimal)value).intValue();
					}
					fields[i].set(t, value);
				
				}
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return list;
	}
	//求最大页数 
	/*int size = select count(*) from 表名
	 int max = size/pageSize;
	 size = 9;
	 pageSize=3;
	
	 int max = (size-1)/pageSize+1
	 	max = (9-1)/3+1=4
	*/
	public  Integer queryMaxPage(Class<T> clazz,int pageSize){
		Integer max = null;
		StringBuffer sql = new StringBuffer("select count(*) from "+clazz.getSimpleName());
		System.out.println(sql.toString());
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			rs.next();
			int size = rs.getInt(1);
			max = (size-1)/pageSize+1;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return max;
	}
	
	//新增
	public  int save(String seq,T t){
		int number=-1;
		StringBuffer sql=new StringBuffer("insert into ");
		//类对象.getClass();
		Class clazz = t.getClass();
		//用clazz得到所有的属性
		Field[] fields = clazz.getDeclaredFields();
		//强力破解
		Field.setAccessible(fields, true);
		//用clazz找到类名
		sql.append(clazz.getSimpleName());
		sql.append(" values("+seq+".nextval,");
		for (int i = 1; i < fields.length; i++) {
			sql.append("?");
			if (i!=fields.length-1) {
				sql.append(",");
			}
		}
		sql.append(")");
		System.out.println(sql.toString());
		Connection conn=null;
		
		PreparedStatement pstmt = null;
		 try {
			//获取连接
			 conn = BaseDao.getConn();
			 //创建statement对象
			 pstmt =conn.prepareStatement(sql.toString());
			 //给占位符赋值
			 for (int i = 1; i < fields.length; i++) {
				 Object vlaue = fields[i].get(t);
				 pstmt.setObject(i, vlaue);
			}
			 number=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, pstmt, conn);
		}
		System.out.println(sql.toString());
		return number;
	}
	public static void main(String[] args) {
		//System.out.println(getConn());
		//new BaseDao<Users2>().queryData(Users2.class);
		//System.out.println(new BaseDao<Users2>().queryData(Users2.class));
	}
	
}
