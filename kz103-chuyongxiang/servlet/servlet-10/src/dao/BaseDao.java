package dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
	public static Connection getConn(){
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl1","scott","orcl");
		} catch (Exception e) {
			// TODO: handle exception
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
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			if(st!=null){
				st.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//测试链接
//	public static void main(String[] args) {
//		System.out.println(getConn());
//	}
	//1.写一个通用的insert语句的方法public int save(Object o)
	
	public static int save(Object o,String seq){
		int num=-1;
		StringBuffer sql=new StringBuffer("insert into");
		Class clazz=o.getClass();
		Field[] fields=clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		sql.append(clazz.getSimpleName());
		sql.append(" values("+seq+".nextval,");
		for (int i = 1; i < fields.length; i++) {
			sql.append("?");
			if(i!=fields.length-1){
				sql.append(",");
			}
		}
		sql.append(")");
		System.out.println(sql.toString());
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=BaseDao.getConn();
			st=conn.prepareStatement(sql.toString());
			for(int i =1;i<fields.length;i++){
				Object value=fields[i].get(o);
				st.setObject(i, value);
			}
			num=st.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, st, conn);
		}
		System.out.println(sql.toString());
		return num;
	}
	
	//2.写一个通用的查询所有数据的方法  public List find(Class c)
	public static List<Object> find(Class c){
		List<Object> list=new ArrayList<Object>();
		StringBuffer sql=new StringBuffer();
		sql.append("select ");
		Field[] fields=c.getDeclaredFields();
		Field.setAccessible(fields, true);
		for(int i=0;i<fields.length;i++){
			sql.append(fields[i].getName());
			if(i!=fields.length-1){
				sql.append(",");
			}
		}
		sql.append(" from "+c.getSimpleName());
		Connection conn = BaseDao.getConn();
		System.out.println(sql);
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st=conn.prepareStatement(sql.toString());
			rs=st.executeQuery();
			while(rs.next()){
				Object obj=c.newInstance();
				for(Field f:fields){
					System.out.println(f.getName());
					Object value =rs.getObject(f.getName());
					System.out.println(value);
					if(value instanceof BigDecimal){
						value = ((BigDecimal)value).intValue();
					}
					if(value instanceof Timestamp){
						value = ((Timestamp)value).toString();
					}
					if(value==null){
						continue;
					}
					f.set(obj, value);
				}
				list.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return list;
	}

	//3.写一个通用的查询某个类的单个数据的方法  
	public Object load(Class c,int id){
			List<Object> list=new ArrayList<Object>();
			StringBuffer sql=new StringBuffer();
			sql.append("select ");
			Field[] fields=c.getDeclaredFields();
			Field.setAccessible(fields, true);
			for(int i=0;i<fields.length;i++){
				sql.append(fields[i].getName());
				if(i!=fields.length-1){
					sql.append(",");
				}
			}
			sql.append(" from "+c.getSimpleName());
			Connection conn = BaseDao.getConn();
			System.out.println(sql);
			PreparedStatement st = null;
			ResultSet rs = null;
			try {
				st=conn.prepareStatement(sql.toString());
				rs=st.executeQuery();
				while(rs.next()){
					Object obj=c.newInstance();
					for(Field f:fields){
						System.out.println(f.getName());
						Object value =rs.getObject(f.getName());
						System.out.println(value);
						if(value instanceof BigDecimal){
							value = ((BigDecimal)value).intValue();
						}
						if(value instanceof Timestamp){
							value = ((Timestamp)value).toString();
						}
						if(value==null){
							continue;
						}
						f.set(obj, value);
					}
					list.add(obj);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				BaseDao.closeConn(rs, st, conn);
			}
			return list;
		}
	
	
	//修改方法
	public int update(Object o){
		int num=-1;
		StringBuffer sql = new StringBuffer();
		sql.append("update ");
		Class clazz = o.getClass();
		Field[] fields = clazz.getDeclaredFields();
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
		Connection conn = BaseDao.getConn();
		PreparedStatement st = null;
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, st, conn);
		}
		return num;
		
	}
	//删除方法
	public int delete(Class c,int id){
		int num=-1;
		StringBuffer sql=new StringBuffer("delete from");
		Class clazz=c.getClass();
		Field[] fields=clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		sql.append(clazz.getSimpleName()+" where "+
				fields[0].getName()+"="+id);
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=BaseDao.getConn();
			st=conn.prepareStatement(sql.toString());
			num = st.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, st, conn);
		}
		System.out.println(sql.toString());
		return num;
	}
}







