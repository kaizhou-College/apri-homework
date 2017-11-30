package pan.dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import pan.entity.Tbl_fwxx;
import pan.entity.Tbl_user;

public class UserDao {
//查看数据库
	public Tbl_user findByNameAndPwd(Tbl_user tbu) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Tbl_user tempau = null;
		try {
			conn = BaseDao.getConn();
			String sql = "select * from tbl_user where uname=? and upass=?";
			st = conn.prepareStatement(sql);
			st.setString(1, tbu.getUname());
			st.setString(2, tbu.getUpass());
			rs = st.executeQuery();
			Class clazz = tbu.getClass();
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields, true);
			while(rs.next()){
				tempau = (Tbl_user) clazz.newInstance();
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
					field.set(tempau, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return tempau;
	}
	//根据id查询为显示页面有的
	public List findById(int uuid) {
		String sql = "select * from tbl_fwxx where uuid = ?";
		List list=new ArrayList(0);
		Class clazz = Tbl_fwxx.class;
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		Connection conn = BaseDao.getConn();
		PreparedStatement st =null;
		ResultSet rs =null;
		conn =BaseDao.getConn();
		try {
			st = conn.prepareStatement(sql.toString());
			//给占位符赋值
			st.setInt(1,uuid);
			rs = st.executeQuery();
			while(rs.next()){
				Tbl_fwxx fw = new Tbl_fwxx();
				for (int i=0;i<fields.length;i++) {
					Object value = rs.getObject(fields[i].getName());
					if (value instanceof BigDecimal) {
						value=((BigDecimal)value).intValue();
					}
					if (value instanceof Timestamp) {
						value= ((Timestamp)value).toString();
					}
					if (value==null) {
						continue;
					}
					fields[i].set(fw, value);
				}
				list.add(fw);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return list;
	}
	//根据id查询为修改页面而有的
	public Tbl_fwxx findId(int fwid) {
		Tbl_fwxx obj = null;
		Connection conn = null;
		PreparedStatement st =null;
		ResultSet rs =null;
		conn =BaseDao.getConn();
		String sql = "select * from tbl_fwxx where fwid = ?";
		try {
			st = conn.prepareStatement(sql.toString());
			//给占位符赋值
			st.setInt(1,fwid);
			rs = st.executeQuery();
			Class clazz = Tbl_fwxx.class;
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields, true);
			while(rs.next()){
				obj = new Tbl_fwxx();
				for (Field field : fields) {
					Object value = rs.getObject(field.getName());
					if (value instanceof BigDecimal) {
						value=((BigDecimal)value).intValue();
					}
					if (value instanceof Timestamp) {
						value= ((Timestamp)value).toString();
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
	/*public static void main(String[] args) {
		System.out.println(new UserDao().findById(2));
	}*/
}
