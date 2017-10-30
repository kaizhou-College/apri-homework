package www.wtg.Dao;

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

import www.wtg.entity.MyUsers;
import www.wtg.entity.Orders;

public class BaseDao{
	public static Connection getconn(){
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "wtg123456");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeconn(ResultSet rs,Statement st, Connection conn){
		try {
			if (rs!=null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
				if (st!=null) {
					st.close();
				}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
				if (conn!=null) {
					conn.close();
				}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//根据ID查询
	public static <T> List<T> findAllById(T t,int id){
		List<T> list=null;
		Class clazz = t.getClass();
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
		sql.append(" from "+clazz.getSimpleName()+" where ");
		String name = fields[0].getName();
		sql.append(name+"=?");
		System.out.println(sql.toString());
		Connection conn = BaseDao.getconn();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql.toString());
			st.setObject(1, id);
			rs = st.executeQuery();
			list=new ArrayList<T>();
			while (rs.next()) {
				Object object = clazz.newInstance();
				for (int i = 0; i < fields.length; i++) {
					
					Object value = rs.getObject(fields[i].getName());
					if (value instanceof BigDecimal) {
						value=((BigDecimal)value).intValue();
					}
					fields[i].set(object, value);
				}
				list.add((T) object);
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
			closeconn(rs, st, conn);
		}
		
		
		return list;
	}
	//查询全部
	public static <T> List<T> findAll(Class clazz){
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
		Connection conn = BaseDao.getconn();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			list=new ArrayList<T>();
			while (rs.next()) {
				Object object = clazz.newInstance();
				for (int i = 0; i < fields.length; i++) {
					Object value = rs.getObject(fields[i].getName());
					if (value instanceof BigDecimal) {
						value=((BigDecimal)value).intValue();
					}
					fields[i].set(object, value);
				}
				list.add((T) object);
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
			closeconn(rs, st, conn);
		}
		
		
		return list;
	}
	
	//新增
	public static <T> int add(T t,String seq){
		int num=-1;
		Class clazz = t.getClass();
		StringBuffer sql=new StringBuffer("insert into "+clazz.getSimpleName()+" values("+seq+".nextval,");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		for (int i = 1; i < fields.length; i++) {
			
			sql.append("?");
			if (i!=fields.length-1) {
				sql.append(",");
			}
		}
		sql.append(")");
		System.out.println(sql.toString());
		Connection conn = BaseDao.getconn();
		PreparedStatement st=null;
		try {
			st=conn.prepareStatement(sql.toString());
			for (int i = 1; i < fields.length; i++) {
			 Object value = fields[i].get(t);
				st.setObject(i, value);
			}
			num = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeconn(null, st, conn);
		}
		return num;
	}
	//删除
	public static <T> int delete(T t,int id){
		int num=-1;
		Class clazz = t.getClass();
		StringBuffer sql=new StringBuffer("delete from "+clazz.getSimpleName()+" where ");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields , true);
		String name = fields[0].getName();
		sql.append(name+"=?");	
		System.out.println(sql.toString());
		Connection conn = BaseDao.getconn();
		PreparedStatement st =null;
		try {
			st = conn.prepareStatement(sql.toString());
			st.setObject(1, id);
			num = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeconn(null, st, conn);
		}
		
		return num;
	}
	//更新
	public static <T> int update(T t,int id) throws IllegalArgumentException, IllegalAccessException{
		int num=-1;
		Class clazz = t.getClass();
		StringBuffer sql=new StringBuffer("update "+clazz.getSimpleName()+" set ");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].get(t)!=null&&!fields[i].get(t).equals(new Integer(0))&&!fields[i].get(t).equals(new Double(0.00))) {
				String name = fields[i].getName();
				sql.append(name+"=?,");
				
			}
			
			
		}
		String substring = sql.substring(0, sql.length()-1);
		StringBuffer sql2=new StringBuffer(substring);
		sql2.append(" where ");
		String name = fields[0].getName();
		sql2.append(name+"=?");
		System.out.println(sql2.toString());
		Connection conn = BaseDao.getconn();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql2.toString());
			int index=1;
			for (int i = 0; i < fields.length; i++) {
				if (fields[i].get(t)!=null&&!fields[i].get(t).equals(new Integer(0))&&!fields[i].get(t).equals(new Double(0.00))) {
					Object value = fields[i].get(t);
					st.setObject(index, value);
					index++;
				}
			}
			st.setObject(index, id);
			num = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			closeconn(null, st, conn);
		}
		return num;
	}
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Orders o=new Orders();
		o.setProdName("篮球1");
		System.out.println(BaseDao.update(o,3));
	}
	
}
