package dao;

import java.io.ObjectInputStream.GetField;
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
import java.util.Iterator;
import java.util.List;

import entity.A;
import entity.emp;

public class BaseDao {
	public static Connection getConn(){
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","orcl");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConn(ResultSet rs,Statement st,Connection conn){
		try {
			if(rs!=null)
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(st!=null)
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(conn!=null)
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//1.写一个通用的insert语句的方法public int save(Object o)

	public static int save(Object obj,String seq) throws Exception{
		int num = -1;
		StringBuffer sql  = new StringBuffer("insert into ");
		Class clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		sql.append(clazz.getSimpleName());
		
		sql.append(" values(");
		for(int i=0;i<fields.length;i++){
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
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql.toString());
			for(int i =0;i<2;i++){
				Object value = fields[i].get(obj);
				st.setObject(i+1, value);
				System.out.println("值"+value+"次数"+i);
			}
			num = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, st, conn);
		}
		return num;
	}
	
	//2.写一个通用的查询所有数据的方法  public List find(Class c)
	public static List frind(Class c) throws InstantiationException, IllegalAccessException {
		List list=new ArrayList();
		StringBuffer buff=new StringBuffer("select  ");
		Field[] fields = c.getDeclaredFields();
		Field.setAccessible(fields,true);
		for (int i = 0; i < fields.length; i++) {
			buff.append(fields[i].getName());
			if(i!=fields.length-1){
				buff.append(",");
			}
		}
		buff.append(" from "+c.getSimpleName());
		System.out.println(buff);
		Connection conn = getConn();
		PreparedStatement statement =null;
		ResultSet rs =null;
		try {
			statement = conn.prepareStatement(buff.toString());
			rs = statement.executeQuery();
			while(rs.next()){
				Object obj = c.newInstance();
				for(Field f:fields){
					Object value = rs.getObject(f.getName());
					if(value instanceof BigDecimal){
						value=((BigDecimal)value).intValue();
					}if(value instanceof Timestamp){
						value = ((Timestamp)value).toString();
					}
					if(value==null){
						continue;
					}
					f.set(obj, value);
					
				}
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConn(rs, statement, conn);
		}
		
		return list;
		
		
	}
	//3.写一个通用的查询某个类的单个数据的方法  public Object load(Class c,int id)
	 public Object load(Class c,int id){
		List list=new ArrayList();
		StringBuffer buff=new StringBuffer("select ");
		
		  
		
		
		
		
		 
		return list;
		 
		 
	 }
	 
	 

//	 6,写一个通用的修改的方法 和删除的方法
//
//	 public int update(Object o)
//	 public int delete(Class c,int id)
	public static int update(Object o) throws Exception{
		int num=0; 
		Class o1=(Class)o;
		StringBuffer buff=new StringBuffer(" update "+o1.getSimpleName()+" set  ");
		Field[] fields = o1.getDeclaredFields();
		Field.setAccessible(fields,true);
		for (int i = 1; i < fields.length; i++) {
			buff.append(fields[i].getName()+"=?");
			if(i!=fields.length-1){
				buff.append(",");
			}
		}
		buff.append(" where "+fields[0].getName()+"=?");
		System.out.println(buff);
		Connection conn = getConn();
		PreparedStatement statement =null;
		int index=1;
		try {
			statement = conn.prepareStatement(buff.toString());
			for (int i = 1; i < fields.length; i++) {
				statement.setObject(index,fields[i].get(o));
				index++;
				if(index==fields.length){
					statement.setObject(index,fields[0].get(o));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConn(null, statement, conn);
		}
		
		
		
		
		return num;
	 }
	public static void main(String[] args) throws Exception {
//		Class cls = Class.forName("entity.A");
//		System.out.println(frind(cls));
//		System.out.println(delete(A.class,1));
		Class forName = Class.forName("entity.A");
		A a=new A();
		a.setAid(1);
		a.setName("fdbgh");
		System.out.println(update(forName));
	}
	public static int delete(Class c,int id){
	int num=0; 
	StringBuffer buff=new StringBuffer("Delete  ");
	Field[] fields = c.getDeclaredFields();
	
	buff.append( c.getSimpleName()+" where " +fields[0].getName()+"=?");
	System.out.println(buff);
	Connection conn = getConn();
	PreparedStatement statement =null;
	try {
		statement = conn.prepareStatement(buff.toString());
		statement.setInt(1,id);
		num = statement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		closeConn(null, statement, conn);
	}
	return num;
		 
	 }
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
