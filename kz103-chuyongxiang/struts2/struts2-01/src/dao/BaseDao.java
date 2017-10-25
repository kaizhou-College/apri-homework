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
import java.util.Date;
import java.util.List;


public class BaseDao {	
	public static Connection getConn(){
		Connection conn =null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl1","scott","orcl");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return conn;
	}
	
	public static void closeConn(ResultSet rs,Statement st,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
			if(st!=null){
				st.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//测试连接
//	public static void main(String[] args) {
//		System.out.println(getConn());
//	}
	
	
	
	//增加
	// insert into 表名 values(序列,?,?,?,?);
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
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql.toString());
			for(int i =1;i<fields.length;i++){
				Object value = fields[i].get(obj);
				st.setObject(i, value);
			}
			num = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, st, conn);
		}
		return num;
	}
	
	
	//测试添加
//	public static void main(String[] args) {
//		Users u= new Users();
//		u.setUname("王富贵");
//		u.setUpassword("159");
//		System.out.println(BaseDao.insert("AA", u));
//	}
	
	//再次测试
//	public static void main(String[] args) {
//		message me=new message();
//		me.setContents("a");
//		me.setCount(1);
//		me.setTitle("a");
//		me.setWriteDate("12-12月-12");
//		me.setWriter("sa");
//		System.out.println(insert("BB",me));
//	}
	
	
	
	//查询
	public static List select(Object obj) throws IllegalArgumentException, IllegalAccessException, InstantiationException{
		List list=new ArrayList();
		Class class1 = obj.getClass();
		Field[] fields = class1.getDeclaredFields();
		Field.setAccessible(fields,true);
		StringBuffer buff=new StringBuffer("select ");
		for (int i = 0; i < fields.length; i++) {
			buff.append(fields[i].getName()+",");
		}
		StringBuffer sql=new StringBuffer(buff.substring(0,buff.length()-1)+" from "+class1.getSimpleName());
		System.out.println(sql);
		Connection conn = getConn();
		PreparedStatement st=null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			while(rs.next()){
				Object object = class1.newInstance();
				for(Field f:fields){
					Object value = rs.getObject(f.getName());
					if(value instanceof BigDecimal){
						value=((BigDecimal)value).intValue();
					}
					if(value instanceof Timestamp){
						value=((Timestamp)value).toString();
					}
					if(value==null){
						continue;
					}
					f.set(object, value);
				}
				list.add(object);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConn(rs, st, conn);
		}
		
		return list;
	}
	//测试
//	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InstantiationException {
//		Users u=new Users();
//		System.out.println(select(u));
//	}

	
	
	//分页
	public static List selectfy(Object obj,int pageindex,int pagesize) throws IllegalArgumentException, IllegalAccessException, InstantiationException{
		List list=new ArrayList();
		Class class1 = obj.getClass();
		Field[] fields = class1.getDeclaredFields();
		Field.setAccessible(fields,true);
		StringBuffer buff=new StringBuffer("select ");
		for (int i = 0; i < fields.length; i++) {
			buff.append(fields[i].getName()+",");
		}
		StringBuffer sql=new StringBuffer(buff.substring(0,buff.length()-1)+" from (select rownum nu,t.* from "+class1.getSimpleName()+" t ) where " +
				"nu>"+(pageindex-1)*pagesize+" and nu<="+pageindex*pagesize);
		System.out.println(sql);
		Connection conn = getConn();
		PreparedStatement st=null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			while(rs.next()){
				Object object = class1.newInstance();
				for(Field f:fields){
					Object value = rs.getObject(f.getName());
					if(value instanceof BigDecimal){
						value=((BigDecimal)value).intValue();
					}
					if(value instanceof Timestamp){
						value=((Timestamp)value).toString();
					}
					if(value==null){
						continue;
					}
					f.set(object, value);
				}
				list.add(object);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConn(rs, st, conn);
		}
		
		return list;
	}
	public static int getCount(Object obj){
		int num=-1;
		Class class1 = obj.getClass();
		StringBuffer buff=new StringBuffer("select count(*) from "+class1.getSimpleName());
		Connection conn = getConn();
		PreparedStatement st =null;
		ResultSet rs =null;
		try {
			st = conn.prepareStatement(buff.toString());
			rs = st.executeQuery();
			rs.next();
			num = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
	}
	public static int getYeShu(Object obj,int pageSize){
		int ye=(getCount(obj)-1)/pageSize+1;
		return ye;
	}
	public static int del(Class clazz,int id){
		StringBuffer sql = new StringBuffer();
		//delete from 表明 where id=?
		sql.append("delete from "+clazz.getSimpleName()+" where ");
		Field[] fields = clazz.getDeclaredFields();
		sql.append(fields[0].getName()+"=?");
//		System.out.println(sql.toString());
		//建立连接
		Connection conn = null;
		PreparedStatement st = null;
		int num = -1;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql.toString());
			st.setInt(1,id);
			num = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, st, conn);
		}
		return num;
	}
	
}
