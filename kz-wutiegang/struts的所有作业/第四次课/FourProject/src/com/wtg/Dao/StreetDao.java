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

import com.wtg.entity.Street;

public class StreetDao {
	//查询所属地区,根据街道id查询
	public String findById(int id){
		Connection conn =null;
		PreparedStatement st=null;
		ResultSet rs = null;
		String ds=null;
		conn = BaseDao.getconn();
		try {
			st=conn.prepareStatement("select d.name||'区'||s.name " +
					"from district d " +
					"inner join " +
					"street s " +
					"on " +
					"d.id=s.district_id" +
					" where s.id=?");
			st.setInt(1, id);
			rs = st.executeQuery();
			while (rs.next()) {
				ds = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ds;
		
		
	}
	//根据street表的id查找district-id
	public int findDiBySid(int sid){
		Connection conn =null;
		PreparedStatement st=null;
		ResultSet rs = null;
		int di=0;
		conn = BaseDao.getconn();
		try {
			st=conn.prepareStatement("select district_id from Street where id=?");
			st.setInt(1, sid);
			rs = st.executeQuery();
			while (rs.next()) {
				di = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return di;
	}
	//根据Street表district-id查找街道名（街道id）
	public List<Street> findSnByDs(Class clazz,int did){
		List list=null;
		Connection conn =null;
		PreparedStatement st=null;
		ResultSet rs = null;
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		conn = BaseDao.getconn();
		try {
			st=conn.prepareStatement("select * from Street where district_id=?");
			st.setInt(1, did);
			rs = st.executeQuery();
			list=new ArrayList();
			while (rs.next()) {
				Street street = (Street) clazz.newInstance();
				for (int i = 0; i < fields.length; i++) {
					Object value = rs.getObject(fields[i].getName());
					if (value instanceof BigDecimal) {
						value=((BigDecimal)value).intValue();
					}
					
					if (value==null) {
						continue;
					}
					fields[i].set(street, value);
				}
				list.add(street);
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
	public static void main(String[] args) {
		System.out.println(new StreetDao().findSnByDs(Street.class, 1004));
	}
}
