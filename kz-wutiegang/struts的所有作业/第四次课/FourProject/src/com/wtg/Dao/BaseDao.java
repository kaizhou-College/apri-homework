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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import com.wtg.entity.House;

public class BaseDao<T> {
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
	public static void closeconn(ResultSet rs,Statement st,Connection conn){
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
	//查询全部
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
			conn = BaseDao.getconn();
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
			closeconn(rs, st, conn);
		}
		return list;
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
			if (fields[i].get(t)!=null&&!fields[i].get(t).equals(new Integer(0))) {
				sql.append(name+",");
				
			}
			
		}
		sql  =new StringBuffer(sql.substring(0, sql.length()-1));
		sql.append(") values("+seq+".nextval");
		for (int i = 0; i < fields.length; i++) {
			try {
				if (fields[i].get(t)!=null&&!fields[i].get(t).equals((new Integer(0)))) {
					sql.append(",?");
					
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
		Connection conn = BaseDao.getconn();
		PreparedStatement st=null;
		try {
			st=conn.prepareStatement(sql.toString());
			int index=1;
			for (int i = 1; i < fields.length; i++) {
			 Object value = fields[i].get(t);
			 if (fields[i].get(t)!=null&&!fields[i].get(t).equals((new Integer(0)))) {
				
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
	public int update(T t,int id) throws IllegalArgumentException, IllegalAccessException{
		int num=-1;
		Class clazz = t.getClass();
		StringBuffer sql=new StringBuffer("update "+clazz.getSimpleName()+" set ");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].get(t)!=null&&!fields[i].get(t).equals(new Integer(0))&&!fields[i].get(t).equals(new Double(0.00))) {
				String name = fields[i].getName();
				if (fields[i].getName().equals("pubdate")) {
					sql.append(name+"=to_date(?,'yyyy-MM-dd'),");
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
		Connection conn = BaseDao.getconn();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql2.toString());
			int index=1;
			for (int i = 0; i < fields.length; i++) {
				if (fields[i].get(t)!=null&&!fields[i].get(t).equals(new Integer(0))&&!fields[i].get(t).equals(new Double(0.00))) {
					Object value = fields[i].get(t);
					if (fields[i].getName().contains("pubdate")) {
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
						sdf.parse((String)value);
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
			closeconn(null, st, conn);
		}
		return num;
	}
	//分页查询
	public List<T> selByPage(Class clazz,int page,int pageSize){
		List<T> list =null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int min = (page-1)*pageSize;
		int max = page*pageSize;
		try {
			conn = getconn();
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
			closeconn(rs, pst, conn);
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
	
	//根据id 查询
	public Object load(Class c,int id){
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
			conn = getconn();
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
						value=((Timestamp)value).toString();
						
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
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeconn(rs, pstmt, conn);
		}
		
		return obj;
	}

	public static void main(String[] args){
	/*	try {
			List<House> list = BaseDao.findAll(House.class);
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*Users u=new Users();

		u.setPassword("333");

		try {
			System.out.println(BaseDao.update(u, 77));
		} catch (IllegalArgumentException e) {+
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(new BaseDao<Types>().MaxPage(Types.class,2));
		System.out.println(new BaseDao<House>().load(House.class, 62));*/
		/*House [contact=444444, description=酷酷酷,
		       floorage=200, id=0, price=100,
		       pubdate=2017-08-09, street_id=0, 
		       title=1111, type_id=0, user_id=0]*/
		House house=new House();
		house.setType_id(1004);
		house.setTitle("新胜路三居 ");
		house.setDescription("海景房1");
		house.setPrice(25000);
		house.setFloorage(300);
		house.setPubdate("2017-08-09");
		house.setContact("1008611111");
		house.setStreet_id(1002);
		try {
			System.out.println(new BaseDao<House>().update(house,80));
			//new BaseDao<House>().update(house, 80);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			System.out.println(new BaseDao<House>().add("seq_id",house));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
