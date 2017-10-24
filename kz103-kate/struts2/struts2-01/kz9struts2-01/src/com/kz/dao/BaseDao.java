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
	 * 1,����Tomcat/conf/context.xml
	 * 2,���ù��̵�web.xml
	 * 3,������������Tomcat/lib��
	 * @return
	 * @throws NamingException 
	 */
	public static Connection getConn() {
		Connection conn = null;
		//Ҫ�����ӳ�
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
				conn.close();//ʹ�����ӳؼ��� ���������Ĺرգ��Ż����ӳ�
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * select �ֶ�1���ֶ�2 from ����
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
	//��ҳ��ѯ
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
	//�����ҳ�� 
	/*int size = select count(*) from ����
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
	
	//����
	public  int save(String seq,T t){
		int number=-1;
		StringBuffer sql=new StringBuffer("insert into ");
		//�����.getClass();
		Class clazz = t.getClass();
		//��clazz�õ����е�����
		Field[] fields = clazz.getDeclaredFields();
		//ǿ���ƽ�
		Field.setAccessible(fields, true);
		//��clazz�ҵ�����
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
			//��ȡ����
			 conn = BaseDao.getConn();
			 //����statement����
			 pstmt =conn.prepareStatement(sql.toString());
			 //��ռλ����ֵ
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
