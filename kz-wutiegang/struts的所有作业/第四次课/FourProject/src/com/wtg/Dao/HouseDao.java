package com.wtg.Dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.wtg.entity.House;
import com.wtg.entity.QueryHouse;

public class HouseDao {
	//判断字符串是否为空
	public boolean strIsNull(String content){
		if (content!=null&&content.trim().length()>0) {
			return true;
		}
		return false;
	}
	//高级查询，根据所选的内容查询
	public List<House> findByContent(QueryHouse qh){
		List<House> list=null;
		
		StringBuffer sql=new StringBuffer("select * from House where 1=1");
		if (strIsNull(qh.getTitle())) {
			  sql.append(" and title like '%"+qh.getTitle()+"%'");
		}
		if (qh.getQueryPrice()==1) {
			sql.append(" and price<=100");
		}else if(qh.getQueryPrice()==2){
			sql.append(" and price>100 and price<=200");
		}else if(qh.getQueryPrice()==3){
			sql.append(" and price>200");
		}
		if (!qh.getAddress().equals("-1")) {
			sql.append(" and street_id="+qh.getAddress());
		}
		if (!qh.getHousemodal().equals("-1")) {
			sql.append(" and type_id="+qh.getHousemodal());
		}
		if (qh.getArea()==1) {
			sql.append(" and floorage<=40");
		}else if(qh.getArea()==2){
			sql.append(" and floorage>40 and floorage<=500");
		}else if(qh.getArea()==3){
			sql.append(" and floorage>500");
		}
		System.out.println(sql.toString());
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs =null;
		list=new ArrayList<House>();
		try {
			Class clazz=House.class;
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields, true);
			conn = BaseDao.getconn();
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			while(rs.next()){
				House h=new House();
				for (int i = 0; i < fields.length; i++) {
					Object value = rs.getObject(fields[i].getName());
					if (value instanceof BigDecimal) {
						value=((BigDecimal)value).intValue();
					}
					if (value instanceof Timestamp) {
						value=((Timestamp)value).toString();
					}
					if(value==null){
						continue;
					}
					fields[i].set(h, value);
				}
				list.add(h);
			}
			
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
			BaseDao.closeconn(rs, st, conn);
		}
		
		return list;
	}
	/*public static void main(String[] args) {
		QueryHouse qh=new QueryHouse();
		qh.setTitle("居");
		qh.setQueryPrice(-1);
		qh.setAddress("-1");
		qh.setHousemodal("-1");
		qh.setArea(-1);
		System.out.println(new HouseDao().findByContent(qh));
	}*/
}
