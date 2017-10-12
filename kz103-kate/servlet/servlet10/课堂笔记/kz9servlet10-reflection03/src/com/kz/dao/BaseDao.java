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

public class BaseDao {
	
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin://127.0.0.1:1521:orcl","scott","tiger");
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
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*ͨ�ò�ѯ
	 * select �ֶ���1,�ֶ���2(������) from ����(����)
	 */
	public static List query(Class clazz){
		List list =null;//new ArrayList();
		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		Field[] fields = clazz.getDeclaredFields();
		//һ�����ƽ��װ
		Field.setAccessible(fields, true);
		for(int i=0;i<fields.length;i++){
			sql.append(fields[i].getName());
			if(i!=fields.length-1){
				sql.append(",");
			}
		}
		sql.append(" from "+clazz.getSimpleName());
		//1,�õ����ݿ�����
		Connection conn = BaseDao.getConn();
		PreparedStatement st = null;
		ResultSet rs = null;
		//2,�õ�statement����
		try {
			st = conn.prepareStatement(sql.toString());
			//3, ִ�в�ѯ
			rs = st.executeQuery();
			//4,��װ�����
			list =new ArrayList();
			while(rs.next()){//��ȡ��
				//����һ��ѧ������
				Object obj = clazz.newInstance();
				for(Field f:fields){//��ȡ��
					//f.setAccessible(true); �ο� line 59
					Object value = rs.getObject(f.getName());
					if(value instanceof BigDecimal){
						value = ((BigDecimal)value).intValue();
					}
					if(value instanceof Timestamp){
						value = ((Timestamp)value).toString();
					}
					if(value==null){
						continue;
					}
					f.set(obj, value);
				}
				//��������뼯��
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return list;
	}
	/*
	 * ͨ����ӣ������ֶΣ�
	 * insert into ���� values(����,?,?,?,?);  sqlע��
	 * insert into ����(�ֶ���1,�ֶ���2....) values(����������);
	 */
	public static int insert(String seq,Object obj){
		int num = -1;
		StringBuffer sql  = new StringBuffer("insert into ");
		Class clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		sql.append(clazz.getSimpleName());
		
		sql.append(" values("+seq+".nextval,");
		for(int i=1;i<fields.length;i++){
			sql.append("?");
			if(i!=fields.length-1){
				sql.append(",");
			}
		}
		sql.append(")");
		System.out.println(sql.toString());
		Connection conn = null;
		PreparedStatement st = null;
		try {
			//1,��ȡ����
			conn = BaseDao.getConn();
			//2,����statement����
			st = conn.prepareStatement(sql.toString());
			//3,��ռλ����ֵ
			for(int i =1;i<fields.length;i++){
				
				Object value = fields[i].get(obj);
				//�ӵ�2�п�ʼ��ֵ
				st.setObject(i, value);
			}
			//4, ִ�����
			num = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, st, conn);
		}
		System.out.println(sql.toString());
		return num;
	}
	//insert into ����(�ֶ���1,�ֶ���2....) values(����������);
	public static int insert2(String seq,Object obj) throws IllegalArgumentException, IllegalAccessException{
		int num = -1;
		StringBuffer sql  = new StringBuffer("insert into ");
		Class clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		sql.append(clazz.getSimpleName());
		sql.append(" ("+fields[0].getName());
		for(int i=1;i<fields.length;i++){
			if(fields[i].get(obj)!=null&&!fields[i].get(obj).equals(new Integer(0))&&!fields[i].get(obj).equals(new Double(0.0))){
				sql.append(",");
				sql.append(fields[i].getName());
			}
		}
		sql.append(") values("+seq+".nextval");
		for(int i=1;i<fields.length;i++){
			if(fields[i].get(obj)!=null&&!fields[i].get(obj).equals(new Integer(0))&&!fields[i].get(obj).equals(new Double(0.0))){
				sql.append(",?");
			}
		}
		sql.append(")");
		Connection conn = null;
		PreparedStatement st = null;
		try {
			//1,��ȡ����
			conn = BaseDao.getConn();
			//2,����statement����
			st = conn.prepareStatement(sql.toString());
			//3,��ռλ����ֵ
			int index = 1;//ռλ�����±� ��1��ʼ
			for(int i=1;i<fields.length;i++){
				if(fields[i].get(obj)!=null&&!fields[i].get(obj).equals(new Integer(0))&&!fields[i].get(obj).equals(new Double(0.0))){
					Object value = fields[i].get(obj);
					//�ӵ�1�п�ʼ��ֵ
					st.setObject(index, value);
					index++;
				}
			}
			//4, ִ�����
			num = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, st, conn);
		}
		System.out.println(sql.toString());
		return num;
	}
	
}







