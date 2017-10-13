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

import entity.USERS;

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
		StringBuffer sql=new StringBuffer("insert into ");
		Class clazz=o.getClass();
		Field[] fields=clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		sql.append(clazz.getSimpleName());
		sql.append(" values(");
		for (int i = 0; i < fields.length; i++) {
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
			for(int i =0;i<fields.length;i++){
				Object value=fields[i].get(o);
				st.setObject(i+1, value);
			}
			num=st.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, st, conn);
		}
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
					Object value =rs.getObject(f.getName());
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
	public static Object load(Class c,int id){
			List list=new ArrayList();
			Field[] fields = c.getDeclaredFields();
			Field.setAccessible(fields, true);
			StringBuffer buff=new StringBuffer("select ");
			for (int i = 0; i < fields.length; i++) {
				buff.append(fields[i].getName());
				if(i!=fields.length-1){
					buff.append(",");
				}
			}
			buff.append(" from "+c.getSimpleName()
					+" where " + fields[0].getName()+"="+id);
			
			Connection conn = getConn();
			PreparedStatement statement = null;
			ResultSet rs =null;
			try {
				statement = conn.prepareStatement(buff.toString());
				rs = statement.executeQuery();
				while(rs.next()){
					Object object = c.newInstance();
					for(Field f:fields){
						Object value = rs.getObject(f.getName());
						if(value instanceof BigDecimal){
							value=((BigDecimal)value).intValue();
						}
						if(value instanceof Timestamp){
							value=((Timestamp)value).toString();
						}
						
						f.set(object, value);
					}
					list.add(object);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(buff);
			return list;
		}
	
//	public static void main(String[] args) throws Exception {
//		Class name = Class.forName("entity.USERS");
//		System.out.println(load(name,1));
//	}
	
	
	//修改方法
	public static  int update(Object o) throws IllegalArgumentException, IllegalAccessException{
		int num=-1;
		Class clazz = o.getClass();
		StringBuffer sql = new StringBuffer();
		sql.append("update "+clazz.getSimpleName()+" set  ");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		for (int i = 1; i < fields.length; i++) {
			if(fields[i].get(o)!=null){
			sql.append(fields[i].getName()+"=?,");
				}
		}
		StringBuffer sql2=new StringBuffer();
		sql2.append(sql.substring(0,sql.toString().length()-1));
		sql2.append(" where "+fields[0].getName()+"=?");
		System.out.println(sql2);
		Connection conn = getConn();
		PreparedStatement statement =null;
		int index=1;
		try {
			statement = conn.prepareStatement(sql2.toString());
			for (int i = 1; i < fields.length; i++) {
				if(fields[i].get(o)!=null){
				statement.setObject(index,fields[i].get(o));
				index++;
					statement.setObject(index,fields[0].get(o));
				}
			}
			num = statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, statement, conn);
		}
		return num;
	}
	
	
	//测试
//	public static void main(String[] args) throws Exception {
//	USERS a=new USERS();
//	a.setId(1);
//	a.setName("王大炮");
//	System.out.println(update(a));
//	}
	
	
	//删除方法
	public static int delete(Class c,int id){
		int num=-1;
		StringBuffer sql=new StringBuffer("delete from ");
		Field[] fields=c.getDeclaredFields();
		Field.setAccessible(fields, true);
		sql.append(c.getSimpleName()+" where "+
				fields[0].getName()+"=?");
		Connection conn=getConn();
		PreparedStatement st=null;
		try {
			st = conn.prepareStatement(sql.toString());
			st.setInt(1,id);
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
	public static void main(String[] args) throws Exception {
//		Class cls = Class.forName("entity.USERS");
//		System.out.println(frind(cls));
		System.out.println(delete(USERS.class,1));
	}
}







