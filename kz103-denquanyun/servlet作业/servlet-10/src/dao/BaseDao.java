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
import java.util.List;

public class BaseDao {
	//��ȡ����
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","abc");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	//�ر�
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
	
	/*дһ��ͨ�õ�insert���ķ���public int save(Object o)*/
	public static int save(Object obj){
		//insert into ����  values(?,?,?);
		StringBuffer sql = new StringBuffer();
		sql.append("insert into ");
		Class clazz = obj.getClass();
		sql.append(clazz.getSimpleName()+" values(");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		for (int i = 0; i < fields.length; i++) {
			sql.append("?");
			if(i!=fields.length-1){
				sql.append(",");
			}
		}
		sql.append(")");
		Connection conn = null;
		PreparedStatement st = null;
		int num=-1;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql.toString());
			for(int i =0;i<fields.length;i++){
				Object value = fields[i].get(obj);
				st.setObject(i+1, value);
			}
			num = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sql);
		return num;
	}
	
	/*дһ��ͨ�õĲ�ѯ�������ݵķ���  public List find(Class c)*/
	public static List find(Class clazz){
		List list =null;
		StringBuffer sql = new StringBuffer();
		//sql��䣺select �ֶ���(����) from ����(����);
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
		//�õ�����
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
	
	//ɾ��
	public static int del(Class clazz,int id){
		StringBuffer sql = new StringBuffer();
		//delete from ���� where id = ?;
		sql.append("delete from ");
		Connection conn = BaseDao.getConn();
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		sql.append(clazz.getSimpleName()+" where "+fields[0].getName()+"="+id);
		PreparedStatement st = null;
		int num = -1;
		try {
			st = conn.prepareStatement(sql.toString());
			num = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sql.toString());
		return num;
	}
	
	//�޸�
	public static int update(Object obj){
		StringBuffer sql = new StringBuffer();
		//update ����  set �ֶ��� = ? where id = ?;
		sql.append("update ");
		Class clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		sql.append(clazz.getSimpleName()+" set ");
		for (int i = 1; i < fields.length; i++) {
			sql.append(fields[i].getName());
			if(i!=fields.length-1){
				sql.append("=?,");
			}
			if(i==fields.length-1){
				sql.append("=?");
			}
		}
		sql.append(" where "+fields[0].getName()+"=?");
		//�õ�����
		Connection conn = BaseDao.getConn();
		PreparedStatement st = null;
		int index=1;
		int num = -1;
		try {
			st = conn.prepareStatement(sql.toString());
			for (int i = 1; i < fields.length; i++) {
				st.setObject(index,fields[i].get(obj));
				index++;
				if(index==fields.length){
					st.setObject(index,fields[0].get(obj));
				}
			}
			num = st.executeUpdate();
			
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
			BaseDao.closeConn(null, st, conn);
		}
		return num;
	}
	
	//3.дһ��ͨ�õĲ�ѯĳ����ĵ������ݵķ���  public Object load(Class c,int id)
	public static List load(Class clazz,int id){
		List list =null;
		StringBuffer sql = new StringBuffer();
		//sql��䣺select �ֶ���(����) from ����(����);
		sql.append("select ");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		for (int i = 0; i < fields.length; i++) {
			sql.append(fields[i].getName());
			if(i!=fields.length-1){
				sql.append(",");
			}
		}
		sql.append(" from "+clazz.getSimpleName()+" where "+fields[0].getName()+"="+id);
		//�õ�����
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
	
}
