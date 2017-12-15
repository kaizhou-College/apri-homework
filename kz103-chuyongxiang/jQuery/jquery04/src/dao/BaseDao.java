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

import entity.City;
import entity.District;
import entity.Province;

public class BaseDao {
	public static Connection getConn(){
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl","scott","orcl");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void CloseConn(ResultSet rs,Statement st,Connection conn){
			try {
				if(rs!=null){
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(st!=null){
					st.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
//	public static void main(String[] args) {
//		System.out.println(getConn());
//	}
	
	//≤È—Ø
	public static List select(Object obj){
		List list=new ArrayList();
		Class class1 = obj.getClass();
		Field[] fields = class1.getDeclaredFields();
		Field.setAccessible(fields,true);
		StringBuffer buff=new StringBuffer("select ");
		for (int i = 0; i < fields.length; i++) {
			buff.append(fields[i].getName()+",");
		}
		StringBuffer sql=new StringBuffer(buff.substring(0,buff.length()-1)+" from "+class1.getSimpleName());
		System.out.println(sql.toString());
		Connection conn = getConn();
		PreparedStatement st=null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			while(rs.next()){
				Object object;
				try {
					object = class1.newInstance();
				
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
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			CloseConn(rs, st, conn);
		}
		
		return list;
	}
	
	//≤‚ ‘≤È—Ø
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InstantiationException {
		District u=new District();
		System.out.println(select(u));
	}
	
}
