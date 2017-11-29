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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.kz.entity.Tbl_fwxx;
import com.kz.entity.Tbl_user;


public class BaseDao {
	//连接数据库
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
	//断开数据库
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
	//查询select * from 表
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
						if (fields[i].getName().equals("zj")) {
							value=((BigDecimal)value).doubleValue();
						}else{
							value=((BigDecimal)value).intValue();
						}
					}
					if (value instanceof Timestamp) {
						value=((Timestamp)value).toString();
						
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
	//删除delete from 表名  where 列名=?
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
				if (name.contains("date")) {
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
					if (fields[i].getName().contains("date")) {
						
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
			closeConn(null, st, conn);
		}
		return num;
	}
	//新增
	public  <T> int add(String seq,T t) throws IllegalArgumentException, IllegalAccessException{
		int num=-1;
		Class clazz = t.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		StringBuffer sql=new StringBuffer("insert into "+clazz.getSimpleName()+"(");
		sql.append(fields[0].getName()+",");
		for (int i = 0; i < fields.length; i++) {
			String name = fields[i].getName();

			if (fields[i].get(t)!=null&&!name.contains("date")) {
				sql.append(name+",");
				
			}
			if (name.contains("date")) {
				sql.append("publishdate,");
			}
		}
		sql  =new StringBuffer(sql.substring(0, sql.length()-1));
		sql.append(") values("+seq+".nextval");
		for (int i = 0; i < fields.length; i++) {
			try {
				if (fields[i].get(t)!=null&&!fields[i].getName().contains("date")) {
						sql.append(",?");
				}
				if (fields[i].getName().contains("date")) {
					sql.append(",sysdate");
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
			closeConn(null, st, conn);
		}
		return num;
	}
	//查询某个类单个数据的方法
	public Object load(Class c,int id) throws InstantiationException, IllegalAccessException {
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
						if (field.getName().equals("zj")) {
							value=((BigDecimal)value).doubleValue();
						}else{
							value=((BigDecimal)value).intValue();
						}
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
			closeConn(rs, pstmt, conn);
		}
		
		
		return obj;
	}
	
	public static void main(String[] args) {
		//System.out.println(BaseDao.getConn());
		BaseDao bd=new BaseDao();
		/*try {
			System.out.println(bd.load(Tbl_user.class, 1));
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Tbl_fwxx tbluser=new Tbl_fwxx();
		tbluser.setTitle("风景");
/*		tbluser.setUname("小二");
		tbluser.setUpass("222");*/
		try {
			System.out.println(bd.add("seq_tblfwxx", tbluser));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
