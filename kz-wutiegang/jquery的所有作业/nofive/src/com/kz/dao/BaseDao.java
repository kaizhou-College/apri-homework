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
	//�������ݿ�
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
	//�Ͽ����ݿ�
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
	//��ѯselect * from ��
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
	//ɾ��delete from ����  where ����=?
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
	//��ѯĳ���൥�����ݵķ���
	public <T> List<T> load(Class c,int id) throws InstantiationException, IllegalAccessException {
		List<T> list=null;
		StringBuffer sql=new StringBuffer("select ");
		//�õ����е�����
		Field[] fields = c.getDeclaredFields();
		Field.setAccessible(fields, true);
		//����Ҫ������ƴ�ӵ�sql�ϲ����ã��Ÿ���
		for (int i = 0; i < fields.length; i++) {
			sql.append(fields[i].getName());
			if (i!=fields.length-1) {
				sql.append(",");
			}
		}
		sql.append(" from "+c.getSimpleName()+" where "+fields[2].getName()+"=?");
		System.out.println(sql.toString()); 
		//�������ݿ�
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
