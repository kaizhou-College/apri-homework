package com.kz.dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.kz.entity.Users;

public class UsersDao {
	public Users findByNameAndPwd(Users users){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Users tempUser = null;
		try {
			conn = BaseDao.getConn();
			String sql = "select * from users where name=? and password=?";
			st = conn.prepareStatement(sql);
			st.setString(1, users.getName());
			st.setString(2, users.getPassword());
			rs = st.executeQuery();
			Class clazz = users.getClass();
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields, true);
			while(rs.next()){
				tempUser = (Users) clazz.newInstance();
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
					field.set(tempUser, value);
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
		
		return tempUser;
	}
	public static void main(String[] args) {
		Users u = new Users();
		u.setName("¶þ¹·×Ó");
		u.setPassword("123");
		System.out.println(new UsersDao().findByNameAndPwd(u));
	}
}
