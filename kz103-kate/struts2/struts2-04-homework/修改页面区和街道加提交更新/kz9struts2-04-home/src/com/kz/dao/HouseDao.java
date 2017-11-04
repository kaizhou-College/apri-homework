package com.kz.dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.kz.entity.House;
import com.kz.entity.QueryHouse;

public class HouseDao {
	public boolean strIsNull(String content){
		if(content!=null&&content.trim().length()>0){
			return true;
		}
		return false;
	}
	
	
	public List<House> queryByCretiera(QueryHouse qh){
		List<House> list = new ArrayList<House>();
		//连接数据库
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		conn =BaseDao.getConn();
		StringBuffer sql =new StringBuffer("select * from house where 1=1 ");
		if(strIsNull(qh.getTitle())){
			sql.append(" and title like '%"+qh.getTitle()+"%'");
		}
		if(qh.getQueryPrice()==1){
			sql.append(" and price<=100");
		}else if(qh.getQueryPrice()==2){
			sql.append(" and price>100 and price <= 200");
		}else if(qh.getQueryPrice()==3){
			sql.append(" and price>200");
		}
		if(!qh.getStreet().equals("-1")){
			sql.append(" and street_id="+qh.getStreet());
		}
		if(!qh.getType().equals("-1")){
			sql.append(" and type_id="+qh.getType());
		}
		if(qh.getArea()==1){
			sql.append(" and floorage<=40");
		}else if(qh.getArea()==2){
			sql.append(" and floorage>40 and floorage <= 500");
		}else if(qh.getArea()==3){
			sql.append(" and floorage>500");
		}
		System.out.println(sql.toString());
		try {
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			list=new ArrayList<House>();
			Class clazz = House.class;
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields, true);
			while(rs.next()){
				House obj = new House();
				for (Field field : fields) {
					Object value = rs.getObject(field.getName());
					if (value instanceof BigDecimal) {
						value=((BigDecimal)value).intValue();
					}
					if (value instanceof Timestamp) {
						//value=((Timestamp)value).toString();
						value= (Timestamp)value;
					}
					if (value==null) {
						continue;
					}
					field.set(obj, value);
				}
				list.add(obj);
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public House findById(int id) {
		House obj = null;
		Connection conn = null;
		PreparedStatement st =null;
		ResultSet rs =null;
		conn =BaseDao.getConn();
		String sql = "select * from house where id = ?";
		try {
			st = conn.prepareStatement(sql.toString());
			//给占位符赋值
			st.setInt(1,id);
			rs = st.executeQuery();
			Class clazz = House.class;
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields, true);
			while(rs.next()){
				obj = new House();
				for (Field field : fields) {
					Object value = rs.getObject(field.getName());
					if (value instanceof BigDecimal) {
						value=((BigDecimal)value).intValue();
					}
					if (value instanceof Timestamp) {
						value= (Timestamp)value;
					}
					if (value==null) {
						continue;
					}
					field.set(obj, value);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	public static void main(String[] args) {
		System.out.println(new HouseDao().findById(1));
	}
		
}
	
