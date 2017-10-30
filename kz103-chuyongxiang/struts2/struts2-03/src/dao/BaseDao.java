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
import java.util.List;

import entity.Orders;
import entity.Users;

public class BaseDao {
	public static Connection getConn(){
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl1","scott","orcl");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
	public static void CloseConn(ResultSet rs,Statement st,Connection conn ){
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
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		System.out.println(getConn());
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
			CloseConn(rs, st, conn);
		}
		
		return list;
	}
	//测试查询
//	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InstantiationException {
//		Users u=new Users();
//		System.out.println(select(u));
//	}
	
	//增加
	public static int insert(String seq,Object obj){
		int num=-1;
		StringBuffer sql=new StringBuffer("insert into ");
		Class clazz=obj.getClass();
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
			for (int i = 1; i < fields.length; i++) {
				Object value=fields[i].get(obj);
				st.setObject(i, value);
			}
			num=st.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			BaseDao.CloseConn(null, st, conn);
		}
		return num;
	}
	//测试增加
//	public static void main(String[] args) {
//		Users u= new Users();
//		u.setUserName("大锤");
//		u.setUserPwd("456");
//		System.out.println(BaseDao.insert("AA", u));
//	}
	
	//删除
	//delete
	public static int delete(Class clazz,int id){
		int num=-1;
		StringBuffer sql=new StringBuffer(" delete from ");
		Connection conn=BaseDao.getConn();
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		sql.append(clazz.getSimpleName()+" where "+fields[0].getName()+"="+id);
		PreparedStatement st=null;
		try {
			st = conn.prepareStatement(sql.toString());
			num = st.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(sql.toString());
		return num;
	}
//	public static void main(String[] args) {
//		System.out.println(delete(Orders.class, 8));
//	}
	
	//修改
	public static int Update(Object obj){
		StringBuffer sql = new StringBuffer();
		//update 表明  set 字段名 = ? where id = ?; 不更改每个属性
		//判断穿过来对象是否为空
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
			BaseDao.CloseConn(null, st, conn);
		}
		
		return num;
	}
	
}
