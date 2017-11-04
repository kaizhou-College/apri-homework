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

import com.kz.entity.Types;
import com.kz.entity.Users;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class TypesDao {
	public Types findById(int id){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Types tempType = null;
		try {
			conn = BaseDao.getConn();
			String sql = "select * from types where id=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			Class clazz = Types.class;
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields, true);
			while(rs.next()){
				tempType = (Types) clazz.newInstance();
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
					field.set(tempType, value);
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
		
		return tempType;
	}
	public static void main(String[] args) {
		System.out.println(new TypesDao().findById(1005) );
	}
}
