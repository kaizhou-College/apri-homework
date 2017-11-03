package com.kz.dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.kz.entity.Street;
import com.kz.entity.Types;

public class StreetDao {
	public String findById(int id){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String districtStreet = null;
		try {
			conn = BaseDao.getConn();
			String sql = "select  "+
				 			"	t2.name||'Çø'|| t1.name "+
				 		"from "+
						"       street t1 "+
						"inner join "+
						"       district t2 "+
						"on "+
						"      t1.district_id = t2.id "+
						"where  "+
						 "      t1.id = ? ";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			while(rs.next()){
				districtStreet = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		
		return districtStreet;
	}
	public static void main(String[] args) {
		//System.out.println(new TypesDao().findById(1005) );
		System.out.println(new StreetDao().findById(1003));
	}
	public Street findById2(int streetId) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Street tempStreet = null;
		try {
			conn = BaseDao.getConn();
			String sql = "select * from street where id=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, streetId);
			rs = st.executeQuery();
			Class clazz = Street.class;
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields, true);
			while(rs.next()){
				tempStreet = (Street) clazz.newInstance();
				for (Field field : fields) {
					Object value = rs.getObject(field.getName());
					if (value instanceof BigDecimal) {
						value=((BigDecimal)value).intValue();
					}
					if (value instanceof Timestamp) {
						value=((Timestamp)value).toString();
					}
					if (value==null) {
						continue;
					}
					field.set(tempStreet, value);
				}
				
			}
		} catch (SQLException e) {
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
		
		return tempStreet;
	}
}
