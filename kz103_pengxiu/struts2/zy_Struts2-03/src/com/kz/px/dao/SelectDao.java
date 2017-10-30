package com.kz.px.dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.kz.px.entity.orders;

public class SelectDao {
	public static List frind(Class c,String qq,String qqq) throws InstantiationException, IllegalAccessException {
		List list=new ArrayList();
		StringBuffer buff=new StringBuffer("select  ");
		Field[] fields = c.getDeclaredFields();
		Field.setAccessible(fields,true);
		for (int i = 0; i < fields.length; i++) {
			buff.append(fields[i].getName());
			if(i!=fields.length-1){
				buff.append(",");
			}
		}
		buff.append(" from "+c.getSimpleName()+" where "+qq+" = "+qqq);
		System.out.println(buff);
		Connection conn = Basedao.getConn();
		PreparedStatement statement =null;
		ResultSet rs =null;
		try {
			statement = conn.prepareStatement(buff.toString());
			
			rs = statement.executeQuery();
			while(rs.next()){
				Object obj = c.newInstance();
				for(Field f:fields){
					Object value = rs.getObject(f.getName());
					if(value instanceof BigDecimal){
						value=((BigDecimal)value).intValue();
					}if(value instanceof Timestamp){
						value = ((Timestamp)value).toString();
					}
					if(value==null){
						continue;
					}
					f.set(obj, value);
					
				}
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeConn(rs, statement, conn);
		}
		return list;
	}
	

	
	public static List frind(Class c) throws InstantiationException, IllegalAccessException {
		List list=new ArrayList();
		StringBuffer buff=new StringBuffer("select  ");
		Field[] fields = c.getDeclaredFields();
		Field.setAccessible(fields,true);
		for (int i = 0; i < fields.length; i++) {
			buff.append(fields[i].getName());
			if(i!=fields.length-1){
				buff.append(",");
			}
		}
		buff.append(" from "+c.getSimpleName());
		System.out.println(buff);
		Connection conn = Basedao.getConn();
		PreparedStatement statement =null;
		ResultSet rs =null;
		try {
			statement = conn.prepareStatement(buff.toString());
			
			rs = statement.executeQuery();
			while(rs.next()){
				Object obj = c.newInstance();
				for(Field f:fields){
					Object value = rs.getObject(f.getName());
					if(value instanceof BigDecimal){
						value=((BigDecimal)value).intValue();
					}if(value instanceof Timestamp){
						value = ((Timestamp)value).toString();
					}
					if(value==null){
						continue;
					}
					f.set(obj, value);
					
				}
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeConn(rs, statement, conn);
		}
		return list;
	}
}
