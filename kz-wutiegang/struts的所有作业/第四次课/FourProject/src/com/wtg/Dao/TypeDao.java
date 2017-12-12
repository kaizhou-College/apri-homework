package com.wtg.Dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wtg.entity.Types;

public class TypeDao {
	public Types findTypeById(int id){
		Connection conn =null;
		PreparedStatement st = null;
		ResultSet rs =null;
		Types type=null;
		Class clazz=Types.class;
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		try {
			conn = BaseDao.getconn();
			st=conn.prepareStatement("select * from Types where id=?");
			st.setInt(1, id);
			rs=st.executeQuery();
			while (rs.next()) {
				type=(Types) clazz.newInstance();
				for (int i = 0; i < fields.length; i++) {
					Object value = rs.getObject(fields[i].getName());
					if (value instanceof BigDecimal) {
						value=((BigDecimal)value).intValue();
					}
					fields[i].set(type, value);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeconn(rs, st, conn);
		}
		
		return type;
	}
	public static void main(String[] args) {
		Types types = new TypeDao().findTypeById(1000);
		
		System.out.println(types.toString());
	}
}
