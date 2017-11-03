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
import java.util.Date;
import java.util.List;

import com.kz.entity.House;
public class BaseDao<T>{
	public static Connection getConn(){
		Connection conn=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin://127.0.0.1:1521:orcl", "kz9", "kz9");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConn(ResultSet rs,Statement st,Connection conn){
		
			try {
				if (rs!=null) {
					rs.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (st!=null) {
					st.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (conn!=null) {
					conn.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	//����
	public  int save(String seq,Object obj){
		int num = -1;
		StringBuffer sql  = new StringBuffer("insert into ");
		Class clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		sql.append(clazz.getSimpleName());
		sql.append(" ("+fields[0].getName());
		try {
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
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
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
	
	public  List<T> find(Class c) throws InstantiationException, IllegalAccessException{
		List list=null;
		StringBuffer sql=new StringBuffer();
		sql.append("select ");
		Field[] fields = c.getDeclaredFields();
		//ǿ���ƽ�
		Field.setAccessible(fields, true);
		for (int i = 0; i < fields.length; i++) {
			sql.append(fields[i].getName());
			if (i!=fields.length-1) {
				sql.append(",");
			}
		}
		sql.append(" from "+c.getSimpleName());
		//�������ݿ�
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		try {
			conn =getConn();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			list=new ArrayList<T>();
			while(rs.next()){
				Object obj = c.newInstance();
				for (Field field : fields) {
					Object value = rs.getObject(field.getName());
					if (value instanceof BigDecimal) {
						value=((BigDecimal)value).intValue();
					}
					if (value instanceof Timestamp) {
						value=((Timestamp)value).toString();
					}
					if (value==null) {
						continue;
					}
					field.set(obj, value);
				}
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, pstmt, conn);
		}
		return list;
	}
	//��ѯĳ���൥�����ݵķ���
	public static List<Object> load(Class c,int id) throws InstantiationException, IllegalAccessException {
		List list=null;
		StringBuffer sql=new StringBuffer("select ");
		Field[] fields = c.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			sql.append(fields[i].getName());
			if (i!=fields.length-1) {
				sql.append(",");
			}
		}
		sql.append(" form "+c.getSimpleName()+" where ");
		for (int i = 0; i < fields.length; i++) {
			sql.append(fields[0]);
		}
		sql.append("=?");
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		try {
			conn = BaseDao.getConn();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			Object obj1 = c.newInstance();
			while(rs.next()){
				for (Field field : fields) {
					Object value = rs.getObject(field.getName());
					field.set(obj1, value);
				}
			}
			list=new ArrayList<Object>();
			//obj.equals(obj1);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			BaseDao.closeConn(null, pstmt, conn);
		}
		
		return null;
	}
	//����-----�����
	public int update(Object o) throws IllegalArgumentException, IllegalAccessException{
		int num=-1;
		StringBuffer sql=new StringBuffer("update ");
		Class c = o.getClass();
		sql.append(c.getSimpleName()+" set ");
		Field[] fields = c.getDeclaredFields();
		Field.setAccessible(fields, true);
		int count = 0;
		for (int i = 1; i < fields.length; i++) {
			if(fields[i].get(o)!=null){
				count++;
				sql.append(fields[i].getName()+"=?");
				if (i!=fields.length-1) {
					sql.append(",");
				}
			}
		}
		//update Users set uname=?,
		//ȥ�����һ����
		sql = new StringBuffer(sql.substring(0, sql.length()-1));
		sql.append(" where ");
		sql.append(fields[0].getName()+"=?");
		System.out.println(sql.toString());
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = BaseDao.getConn();
			pstmt = conn.prepareStatement(sql.toString());
			int index=0;
			for (int i = 1; i < fields.length; i++) {
				Object value = fields[i].get(o);
				if(value!=null){
					index++;
					pstmt.setObject(index,value);
				}
			}
			pstmt.setObject(index+1, fields[0].get(o));
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, pstmt, conn);
		}
		return num;
	}
	//ɾ��
	public int delete(Class c,int id){
		int number=-1;
		StringBuffer sql=new StringBuffer("delete from "+c.getSimpleName()+" where ");
		Field[] fields = c.getDeclaredFields();
		Field.setAccessible(fields, true);
		sql.append(fields[0].getName()+"=?");
		//System.out.println(sql.toString());
		Connection conn = null;
		PreparedStatement pstmt =null;
		try {
			conn = BaseDao.getConn();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setObject(1,id);
			number = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, pstmt, conn);
		}
		System.out.println(sql.toString());
		return number;
	}
	//ͨ�õķ�ҳ��ѯ
	public List<T> selByPage(Class clazz,int page,int pageSize){
		List<T> list =null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int min = (page-1)*pageSize;
		int max = page*pageSize;
		try {
			conn = getConn();
			String sql  ="select * from" +
					"(select rownum num,t.* from House t)" +
					" where num>? and num<=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, min);
			pst.setInt(2,max);
			rs = pst.executeQuery();
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields, true);
			list=new ArrayList<T>();
			while(rs.next()){
				T obj = (T) clazz.newInstance();
				for (Field field : fields) {
					Object value = rs.getObject(field.getName());
					if (value instanceof BigDecimal) {
						value=((BigDecimal)value).intValue();
					}
					if (value instanceof Timestamp) {
						//value=((Timestamp)value).toString();
						value = (Timestamp)value;
					}
					if (value==null) {
						continue;
					}
					field.set(obj, value);
				}
				list.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, pst, conn);
		}
		
		return list;
	}
	//�õ���ҳ���ķ���  ��ҳ��=������/ÿҳ������
	public static int getMaxPage(Class clazz,int pagesize){
		int max = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConn();
			String sql  ="select count(*) from "+clazz.getSimpleName();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			rs.next();
			int size = rs.getInt(1);
			//size=27  pagesize=5  max=6ҳ!=27/5=5
			//size=27 pagesize=9   max=3ҳ=27/9=3
			max =(size-1)/pagesize+1;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, pst, conn);
		}
		return max;
	}
	public static void main(String[] args) {
		/*Users u = new Users();
		u.setName("������");
		u.setPassword("123");
		System.out.println(new BaseDao<Users>().save("seq_users", u));*/
		for(House h :new BaseDao<House>().selByPage(House.class, 1, 2)){
			System.out.println(h);
			
		}
		
	}
	
	
}
