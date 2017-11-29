package com.kz.examination.utils;

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

public class Returns {
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "scott", "orcl");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void getClose(ResultSet rs, Statement st, Connection conn) {

		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (st != null)
				st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List returnList(Object obj,String sql){
		List list=null;
		Class class1 = obj.getClass();
		Field[] fields = class1.getDeclaredFields();
		Field.setAccessible(fields, true);
		Connection conn =new Returns().getConn();
		PreparedStatement st =null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			list=new ArrayList();
			while(rs.next()){
				Object object=null;
				try {
					object = class1.newInstance();
				
					for(Field f:fields){
						Object values = rs.getObject(f.getName());
						if(values instanceof BigDecimal){
							 values=((BigDecimal)values).intValue();
						}if(values instanceof Timestamp){
							values = ((Timestamp)values).toString();
						}
						if(values==null){
							continue;
						}
						f.set(object,values);
					}
					list.add(object);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int  returnUID(Object obj,String sql,boolean IsCount){
		Class class1 = obj.getClass();
		Field[] fields = class1.getDeclaredFields();
		Field.setAccessible(fields, true);
		int num=-1;
		Connection conn = getConn();
		PreparedStatement st =null;
		ResultSet rs=null;
		try {
			st = conn.prepareStatement(sql);
			if(IsCount){
				num=st.executeUpdate();
			}else{
				
				rs=st.executeQuery();
				rs.next();
				num=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(IsCount){
				getClose(null, st, conn);
			}else{
				getClose(rs, st, conn);
			}
			
		}
		return num;
	}
}
