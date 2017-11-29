package dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import entity.Tbl_Fwlx;


public class FwlxDao {
	//根据ID查询
	public static Tbl_Fwlx findById(int id) {
		Tbl_Fwlx obj = null;
		Connection conn = null;
		PreparedStatement st =null;
		ResultSet rs =null;
		conn =BaseDao.getConn();
		String sql = "select * from Tbl_Fwlx where lxid = ?";
		try {
			st = conn.prepareStatement(sql.toString());
			//给占位符赋值
			st.setInt(1,id);
			rs = st.executeQuery();
			Class clazz = Tbl_Fwlx.class;
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields, true);
			while(rs.next()){
				obj = new Tbl_Fwlx();
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
	//测试根据ID查询
	public static void main(String[] args) {
		System.out.println(findById(2));
	}
}
