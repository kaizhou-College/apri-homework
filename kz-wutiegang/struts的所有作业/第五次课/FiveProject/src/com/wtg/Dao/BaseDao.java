package com.wtg.Dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Result;
import com.wtg.entity.Auction;
import com.wtg.entity.AuctionUser;

public class BaseDao {
	public static Connection getConn(){
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
	public static void closeConn(ResultSet rs,Connection conn,Statement st){
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
	//查询select * from 表名
	public static <T> List<T> findAll(Class c) throws InstantiationException, IllegalAccessException{
		List list=null;
		StringBuffer sql=new StringBuffer();
		sql.append("select ");
		Field[] fields = c.getDeclaredFields();
		//强力破解
		Field.setAccessible(fields, true);
		for (int i = 0; i < fields.length; i++) {
			sql.append(fields[i].getName());
			if (i!=fields.length-1) {
				sql.append(",");
			}
		}
		sql.append(" from "+c.getSimpleName());
		System.out.println(sql.toString());
		//连接数据库
		Connection conn = null;
		PreparedStatement st =null;
		ResultSet rs =null;
		try {
			conn =getConn();
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			list=new ArrayList<T>();
			while(rs.next()){
				T t = (T) c.newInstance();
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
					field.set(t, value);
				}
				
				list.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConn(rs,conn ,st);
		}
		return list;
	}
	///删除
	public static <T> int delete(T t,int id){
		int num=-1;
		Class clazz = t.getClass();
		StringBuffer sql=new StringBuffer("delete from "+clazz.getSimpleName()+" where ");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields , true);
		String name = fields[0].getName();
		sql.append(name+"=?");	
		System.out.println(sql.toString());
		Connection conn = getConn();
		PreparedStatement st =null;
		try {
			st = conn.prepareStatement(sql.toString());
			st.setObject(1, id);
			num = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConn(null, conn, st);
		}
		
		return num;
	}
	//查询某个类单个数据的方法
	public static Object load(Class c,int id) throws InstantiationException, IllegalAccessException {
		Object obj=null;
		StringBuffer sql=new StringBuffer("select ");
		//得到所有的属性
		Field[] fields = c.getDeclaredFields();
		Field.setAccessible(fields, true);
		//把需要的属性拼接到sql上并且用，号隔开
		for (int i = 0; i < fields.length; i++) {
			sql.append(fields[i].getName());
			if (i!=fields.length-1) {
				sql.append(",");
			}
		}
		sql.append(" from "+c.getSimpleName()+" where "+fields[0].getName()+"=?");
		System.out.println(sql.toString()); 
		//连接数据库
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		
		try {
			conn = BaseDao.getConn();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setObject(1, id);	
			rs = pstmt.executeQuery();
			while(rs.next()){
				obj = c.newInstance();
				for (Field field : fields) {
					Object value = rs.getObject(field.getName());
					if (value instanceof BigDecimal) {
						value=((BigDecimal)value).intValue();
					}
					if (value instanceof Timestamp) {
						value=(((Timestamp)value).toString()).substring(0, 19);
						//System.out.println(value+"===快快乐乐hhh");
						
					}
					if (value==null) {
						continue;
					}
					
					field.set(obj, value);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConn(rs, conn, pstmt);
		}
		
		
		return obj;
	}
	//分页查询
	public <T> List<T> selByPage(Class clazz,int page,int pageSize){
		List<T> list =null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int min = (page-1)*pageSize;
		int max = page*pageSize;
		try {
			conn = getConn();
			String sql  ="select * from" +
					" (select rownum num,t.* from Auction t)" +
					" where num>? and num<=?";
			System.out.println(sql);
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
						value=((Timestamp)value).toString();
						
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
			closeConn(rs, conn, pst);
		}
		
		return list;
	}
	//求最大页数
	public int MaxPage(Class clazz,int pageSize){
		int num=-1;
		try {
			List<Object> list = findAll(clazz);
			int size = list.size();
			num=(size-1)/pageSize+1;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return num;
	}
	//更新
	public <T> int update(T t,int id) throws IllegalArgumentException, IllegalAccessException{
		int num=-1;
		Class clazz = t.getClass();
		StringBuffer sql=new StringBuffer("update "+clazz.getSimpleName()+" set ");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		for (int i = 1; i < fields.length; i++) {
			if (fields[i].get(t)!=null) {
				String name = fields[i].getName();
				if (name.contains("time")) {
					sql.append(name+"=to_date(?,'yyyy-MM-dd hh24:mi:ss'),");
				}else{
					sql.append(name+"=?,");
				}	
				}
			}
		String substring = sql.substring(0, sql.length()-1);
		StringBuffer sql2=new StringBuffer(substring);
		sql2.append(" where ");
		String name = fields[0].getName();
		sql2.append(name+"=?");
		System.out.println(sql2.toString());
		Connection conn = BaseDao.getConn();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql2.toString());
			int index=1;
			for (int i = 1; i < fields.length; i++) {
				if (fields[i].get(t)!=null) {
					Object value = fields[i].get(t);
					System.out.println(value);
					if (fields[i].getName().contains("time")) {
						
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						sdf.parse((String) value);
					}
					st.setObject(index, value);
					index++;
				}
			}
			//给最后一个占位符赋值
			st.setObject(index, id);
			num = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			BaseDao.closeConn(null, conn, st);
		}
		return num;
	}
	//新增
	public static <T> int add(String seq,T t) throws IllegalArgumentException, IllegalAccessException{
		int num=-1;
		Class clazz = t.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		StringBuffer sql=new StringBuffer("insert into "+clazz.getSimpleName()+"(");
		sql.append(fields[0].getName()+",");
		for (int i = 0; i < fields.length; i++) {
			String name = fields[i].getName();
			if (fields[i].get(t)!=null) {
				sql.append(name+",");
				
			}
			
		}
		sql  =new StringBuffer(sql.substring(0, sql.length()-1));
		sql.append(") values("+seq+".nextval");
		for (int i = 0; i < fields.length; i++) {
			try {
				if (fields[i].get(t)!=null) {
					if (fields[i].getName().contains("time")) {
						sql.append(",to_date(?,'yyyy-MM-dd hh24:mi:ss')");
					}else{
						sql.append(",?");
					}
					
					
				}
				
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		sql.append(")");
		System.out.println(sql.toString());
		Connection conn = BaseDao.getConn();
		PreparedStatement st=null;
		try {
			st=conn.prepareStatement(sql.toString());
			int index=1;
			for (int i = 1; i < fields.length; i++) {
			 Object value = fields[i].get(t);
			 if (value!=null) {
				
				 	st.setObject(index, value);
					index++;
					
				}
			}
			num = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, conn, st);
		}
		return num;
	}
	public static void main(String[] args) {
		/*try {
			System.out.println(BaseDao.findAll(AuctionUser.class));
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*try {
			System.out.println(BaseDao.load(AuctionUser.class, 2));
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		BaseDao basedao=new BaseDao();
		try {
			Auction auction =new Auction();
			auction.setAuctionid(1);
			auction.setAuctionname("红楼梦");
			auction.setAuctiondesc("中国四大名著之一");
			auction.setAuctionstarttime("2017-11-1 01:03:00");
			auction.setAuctionendtime("2017-11-17 01:03:00");
			auction.setAuctionpic("a.png");
			System.out.println(basedao.update(auction, 1));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*Auction auction =new Auction();
		auction.setAuctionname("西游记");
		auction.setAuctionstartprice(100);
		auction.setAuctionupset(1000);
		auction.setAuctionstarttime("2017-11-16 01:12:13");
		auction.setAuctionendtime("2017-11-17");
		auction.setAuctionpictype("国书");
		auction.setAuctiondesc("中国四大名著之一");
		auction.setAuctionpic("7.jpg");
		try {
			System.out.println(BaseDao.add("seq_auction", auction));
	
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
