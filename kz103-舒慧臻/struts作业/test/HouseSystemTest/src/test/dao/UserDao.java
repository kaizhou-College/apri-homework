package test.dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import test.entity.Tbl_Fwlx;
import test.entity.Tbl_Fwxx;
import test.entity.Tbl_User;

public class UserDao {
	//查询用户名和密码
	public Tbl_User queryNameAndPwdza(Tbl_User user){
		Connection conn = BaseDao.getConn();
		PreparedStatement st = null;
		ResultSet rs = null;
		Tbl_User list = null;
		try {
			String sql = "select * from TBL_USER where uname = ? and upass = ?";
			st = conn.prepareStatement(sql);
			Class clazz = user.getClass();
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields, true);
			st.setString(1,user.getUname());
			st.setString(2, user.getUpass());
			rs = st.executeQuery();
			while(rs.next()){
				list = (Tbl_User) clazz.newInstance();
				for (Field field : fields) {
					Object value = rs.getObject(field.getName());
					if(value instanceof BigDecimal){
						value = ((BigDecimal)value).intValue();
					}
					if(value instanceof Timestamp){
						value = ((Timestamp)value).toString();
					}
					if(value ==null){
						continue;
					}
					field.set(list, value);
				}
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
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return list;
	}

	// 根据id来查
	public static Object queryById(Class clazz, int id) {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from ");
		sql.append(clazz.getSimpleName());
		sql.append(" where ");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		sql.append(fields[0].getName());
		sql.append("=?");
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Object obj = null;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql.toString());
			// 给占位符赋值
			st.setInt(1, id);
			rs = st.executeQuery();
			while (rs.next()) {
				obj = clazz.newInstance();
				for (Field field : fields) {
					Object value = rs.getObject(field.getName());
					if (value instanceof BigDecimal) {
						value = ((BigDecimal) value).intValue();
					}
					if (value instanceof Timestamp) {
						value = ((Timestamp) value).toString();
					}
					if (value == null) {
						continue;
					}
					field.set(obj, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeConn(rs, st, conn);
		}
		return obj;
	}
	
	//删除之后的ID查询
	public static Object ReQueryById(Class clazz, Object id) {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from ");
		sql.append(clazz.getSimpleName());
		sql.append(" where ");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		sql.append("uuid=?");
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Object obj = null;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql.toString());
			// 给占位符赋值
			st.setObject(1, id);
			rs = st.executeQuery();
			while (rs.next()) {
				obj = clazz.newInstance();
				for (Field field : fields) {
					Object value = rs.getObject(field.getName());
					if (value instanceof BigDecimal) {
						value = ((BigDecimal) value).intValue();
					}
					if (value instanceof Timestamp) {
						value = ((Timestamp) value).toString();
					}
					if (value == null) {
						continue;
					}
					field.set(obj, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeConn(rs, st, conn);
		}
		return obj;
	}
	
	public static void main(String[] args) {
		/*Tbl_User user = new Tbl_User();
		user.setUname("张飞");
		user.setUpass("222");
		System.out.println(new UserDao().queryNameAndPwdza(user));*/
//		System.out.println(new UserDao().ReQueryById(Tbl_User.class, 2));
//		System.out.println(new UserDao().queryById(Tbl_Fwlx.class, 2));
	}

}
