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
import java.util.ArrayList;
import java.util.List;

import com.wtg.entity.StudentInfo;

public class BaseDao {
	public static Connection getConn(){
		Connection conn=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin://127.0.0.1:1521:orcl", "scott", "wtg123456");
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
	//新增
	public static int save(String seq,Object o){
		int number=-1;
		StringBuffer sql=new StringBuffer("insert into ");
		//类对象.getClass();
		Class clazz = o.getClass();
		//用clazz得到所有的属性
		Field[] fields = clazz.getDeclaredFields();
		//强力破解
		Field.setAccessible(fields, true);
		//用clazz找到类名
		sql.append(clazz.getSimpleName());
		sql.append(" values("+seq+".nextval,");
		for (int i = 1; i < fields.length; i++) {
			sql.append("?");
			if (i!=fields.length-1) {
				sql.append(",");
			}
		}
		sql.append(")");
		System.out.println(sql.toString());
		Connection conn=null;
		
		PreparedStatement pstmt = null;
		 try {
			//获取连接
			 conn = BaseDao.getConn();
			 //创建statement对象
			 pstmt =conn.prepareStatement(sql.toString());
			 //给占位符赋值
			 for (int i = 1; i < fields.length; i++) {
				 Object vlaue = fields[i].get(o);
				 pstmt.setObject(i, vlaue);
			}
			 number=pstmt.executeUpdate();
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
			BaseDao.closeConn(null, pstmt, conn);
		}
		System.out.println(sql.toString());
		return number;
	}
	//查询全部
	public static List find(Class c) throws InstantiationException, IllegalAccessException{
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
		//连接数据库
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		try {
			conn = BaseDao.getConn();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			list=new ArrayList<StudentInfo>();
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
		}finally{
			BaseDao.closeConn(rs, pstmt, conn);
		}
		
		
		return obj;
	}
	//更新
	public int update(Object o) throws IllegalArgumentException, IllegalAccessException{
		int num=-1;
		StringBuffer sql=new StringBuffer("update ");
		Class c = o.getClass();
		sql.append(c.getSimpleName()+" set ");
		Field[] fields = c.getDeclaredFields();
		Field.setAccessible(fields, true);
		for (int i = 1; i < fields.length; i++) {
			if (fields[i].get(o)!=null&&!fields[i].get(o).equals(new Integer(0))&&!fields[i].get(o).equals(new Double(0.0))) {
				sql.append(fields[i].getName()+"=?,");
			}

		}
		sql=new StringBuffer(sql.substring(0, sql.length()-1));
		
		sql.append(" where ");
		sql.append(fields[0].getName()+"=?");
		System.out.println(sql.toString());
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = BaseDao.getConn();
			pstmt = conn.prepareStatement(sql.toString());
			//初始化占位符为1
			int index=1;

			for (int i = 1 ; i < fields.length; i++) {
				Object value  = fields[i].get(o);
				if (fields[i].get(o)!=null&&!fields[i].get(o).equals(new Integer(0))&&!fields[i].get(o).equals(new Double(0.0))) {
					pstmt.setObject(index,value);
				}
				index++;
				
			}

			pstmt.setObject(index-1, fields[0].get(o));
			num = pstmt.executeUpdate();
			
			System.out.println(index);
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
			BaseDao.closeConn(null, pstmt, conn);
		}
		return num;
	}
	//删除
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
			pstmt.setObject(1, id);
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
}
