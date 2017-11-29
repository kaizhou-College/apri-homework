package dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entity.Tbl_Jd;



public class JdDao {
	//根据ID查询
	public static Tbl_Jd findById(int id) {
		Tbl_Jd obj = null;
		Connection conn = null;
		PreparedStatement st =null;
		ResultSet rs =null;
		conn =BaseDao.getConn();
		String sql = "select * from Tbl_Jd where jdid = ?";
		try {
			st = conn.prepareStatement(sql.toString());
			//给占位符赋值
			st.setInt(1,id);
			rs = st.executeQuery();
			Class clazz = Tbl_Jd.class;
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields, true);
			while(rs.next()){
				obj = new Tbl_Jd();
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
	
	public static List<Tbl_Jd> findById2(int id){
		List list=null;
		Connection conn = BaseDao.getConn();
		String sql="select * from Tbl_Jd where jdid = "+id;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			list=new ArrayList();
			rs = st.executeQuery();
			Tbl_Jd ur=new Tbl_Jd();
			Class class1 = ur.getClass();
			Field[] fields = class1.getDeclaredFields();
			Field.setAccessible(fields, true);
			System.out.println(sql);
			while (rs.next()) {
				Object object;
				try {
					object = class1.newInstance();
					for (int i = 0; i < fields.length; i++) {
						Object value = rs.getObject(fields[i].getName());
						if(value instanceof Timestamp){
							value = ((Timestamp)value).toString();
						}
						if(value instanceof BigDecimal){
							value = ((BigDecimal)value).intValue();
						}
						fields[i].set(object, value);
					}
					list.add(object);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return list;
	}
	
	
	//测试根据ID查询
	public static void main(String[] args) {
		System.out.println(findById2(3));
	}
}
