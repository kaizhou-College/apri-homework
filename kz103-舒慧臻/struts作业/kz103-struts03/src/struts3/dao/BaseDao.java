package struts3.dao;

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

import struts3.entity.Orders;
import struts3.entity.Users1;

public class BaseDao {
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "abc");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConn(ResultSet rs ,Statement st , Connection conn){
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
	
	//增加
	public static int add(String seq,Object obj){
		//insert into 表明(字段名) values(key.nextval,字段名)
		StringBuffer sql = new StringBuffer();	
		Class clazz = obj.getClass();
		sql.append("insert into "+clazz.getSimpleName()+"(");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		sql.append(fields[0].getName()+",");
		int count=0;
		for (int i = 1; i < fields.length; i++) {
			if(fields[i]!=null){
				count++;
				sql.append(fields[i].getName()+",");
			}
		}
		String string = sql.substring(0,sql.lastIndexOf(","));
		StringBuffer sql1 = new StringBuffer(string);
		sql1.append(") values("+seq+".nextval,");
		for (int i = 1; i < fields.length; i++) {
			if(fields[i]!=null){
				sql1.append("?");
				if(i<count){
					sql1.append(",");
				}
			}
		}
		sql1.append(")");
		System.out.println(sql1.toString());
		//得到链接
		Connection conn = null;
		PreparedStatement st = null;
		int num=-1;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql1.toString());
			for(int i =1;i<fields.length;i++){
				Object value = fields[i].get(obj);
				if(value instanceof Integer){
					value = ((Integer)value).intValue();
				}
				if(value ==null){
					continue;
				}
				st.setObject(i,value);
			}
			num = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, st, conn);
		}
		System.out.println(sql1.toString());
		return num;
	}
	//删
	public static int del(Class clazz,int id){
		StringBuffer sql = new  StringBuffer();
		sql.append("delete from ");
		Connection conn = BaseDao.getConn();
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
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
//修改
	public static int Update(Object obj){
		StringBuffer sql = new StringBuffer();
		sql.append("update ");
		Class clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		sql.append(clazz.getSimpleName()+" set ");
		for (int i = 1; i < fields.length; i++) {
			try {
				if(fields[i].get(obj)!=null&&!fields[i].get(obj).equals(new Integer(0))&&!fields[i].get(obj).equals(new Double(0.0))){
					sql.append(fields[i].getName()+" =?,");
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		StringBuffer sql2 = new StringBuffer(sql.substring(0,sql.length()-1));
		sql2.append(" where "+fields[0].getName()+"=?");
		//得到链接
		Connection conn = null;
		PreparedStatement st = null;
		int index=0;
		int num = -1;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql2.toString());
			for (int i = 1; i < fields.length; i++) {
				if(fields[i].get(obj)!=null&&!fields[i].get(obj).equals(new Integer(0))&&!fields[i].get(obj).equals(new Double(0.0))){
					index++;
					st.setObject(index,fields[i].get(obj));
				}
			}
			st.setObject(index+1,fields[0].get(obj));
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
	//查
	public  static List query(Class clazz){
		List list = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		for (int i = 0; i < fields.length; i++) {
			sql.append(fields[i].getName());
			if(i!=fields.length-1){
				sql.append(",");
			}
		}
		sql.append(" from "+clazz.getSimpleName());
		Connection conn = BaseDao.getConn();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			list = new ArrayList();
			while(rs.next()){
				Object obj = clazz.newInstance();
				for (Field field : fields) {
					Object value = rs.getObject(field.getName());
					if(value instanceof BigDecimal){
						value = ((BigDecimal)value).intValue();
					}
					if(value instanceof Timestamp){
						value = ((Timestamp)value).toString();
					}
					if(value==null){
						continue;
					}
					field.set(obj, value);
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
	
	
	public static void main(String[] args) {
		System.out.println(BaseDao.getConn());
		BaseDao dao = new BaseDao();
		Users1 user = new Users1();
		//增
/*		user.setUsername("孙二娘");
		user.setUserpwd("123243");
		System.out.println(dao.add("seq_users1", user));*/
		Orders or = new Orders();
/*		or.setCustname("宋江");
		or.setOrdercount(900);
		or.setProdname("弓箭");
		or.setOrderdate("27-10月-17");
		System.out.println(dao.add("seq_orders", or));*/
		//删
		//System.out.println(dao.del(or.getClass(), 3));
		//改
	/*	user.setUserid(1);
		user.setUsername("鲁智深");
		user.setUserpwd("12324");
		System.out.println(dao.Update(user));*/
		//查
		System.out.println(dao.query(user.getClass()));
		
		
		
	}

}
