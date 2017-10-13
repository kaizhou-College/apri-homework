package work10.dao;

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
			conn = DriverManager.getConnection("jabc:oracle:thin://127.0.0.1:1521:orcl", "scott", "abc");
		} catch (ClassNotFoundException e) {
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
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//1.写一个通用的insert语句的方法public int save(Object o)
	public static int save(String seq,Object obj){
		int num = -1;//错误报-1
		StringBuffer sf = new StringBuffer("insert into ");
		Class class1 = obj.getClass();
		Field[] fields = class1.getDeclaredFields();
		sf.append(class1.getSimpleName());
		Field.setAccessible(fields, true);
		sf.append(" values("+seq+".nextval,");
		for (int i = 1; i < fields.length; i++) {
			sf.append("?");
			if(i!=fields.length-1){
				sf.append(",");
			}
		}
		sf.append(")");
		System.out.println(sf.toString());
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sf.toString());
			//给占位符赋值
			for (int i = 1; i < fields.length; i++) {
				Object value = fields[i].get(obj);
				st.setObject(i, value);
			}
			num = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, st, conn);
		}
		System.out.println(sf.toString());
		return num;
	}
	
	
	//2.写一个通用的查询所有数据的方法  public List find(Class c)
	public List find(Class c){
		List list = null;
		StringBuffer sf = new StringBuffer();
		sf.append("select ");
		Field[] fields = c.getDeclaredFields();
		Field.setAccessible(fields, true);
		for (int i = 0; i < fields.length; i++) {
			sf.append(fields[i].getName());
			if(i!=fields.length-1){
				sf.append(",");
			}
		}
		sf.append(" from "+c.getSimpleName());
		System.out.println(sf.toString());
		Connection conn = BaseDao.getConn();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sf.toString());
			rs = st.executeQuery();
			//封裝結果集
			list = new ArrayList();
			while(rs.next()){
				//創建一個對象
				Object obj = c.newInstance();
				//獲取列
				for (Field field : fields) {
					Object value = rs.getObject(field.getName());
					if(value instanceof BigDecimal){
						value = ((BigDecimal)value).toString();
					}
					if(value instanceof Timestamp){
						value = ((Timestamp)value).toString();
					}
					if(value == null){
						continue;
					}
					field.set(obj, value);
				}
				//將對象放入集合
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return list;
	}
	//3.写一个通用的查询某个类的单个数据的方法  public Object load(Class c,int id)  待修改
	public static List load(Class clazz,int id){
		List list =null;
		StringBuffer sql = new StringBuffer();
		//sql语句：select 字段名(属性) from 表明(类名);
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
		//得到链接
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
	
	//修改
	public static int update(Object obj){
		StringBuffer sf = new StringBuffer();
		sf.append("update ");
		Class class1 = obj.getClass();
		Field[] fields = class1.getDeclaredFields();
		Field.setAccessible(fields, true);
		sf.append(class1.getSimpleName()+" set ");
		for (int i = 0; i < fields.length; i++) {
			sf.append(fields[i].getName());
			if(i!= fields.length-1){
				sf.append("=?");
			}
			if(i!=fields.length-1){
				sf.append("=?");
			}
		}
		sf.append(" where "+fields[0].getName()+"=?");
		//得到链接
		Connection conn = BaseDao.getConn();
		PreparedStatement st = null;
		int index=1;
		int num = -1;
		try {
			st = conn.prepareStatement(sf.toString());
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
	
	//删除
	public static int del(Class clazz,int id){
		StringBuffer sql = new StringBuffer();
		//delete from 表明 where id = ?;
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
	
}
