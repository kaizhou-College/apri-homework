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

import entity.District;


public class DistrictDao {
	//根据ID查询
	public static List<District> Districtselect(int id){
		List list=null;
		Connection conn = BaseDao.getConn();
		String sql="select * from District where cid = "+id;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			list=new ArrayList();
			rs = st.executeQuery();
			District ur=new District();
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
			BaseDao.CloseConn(rs, st, conn);
		}
		return list;
	}
	
	
	//测试根据ID查询
	public static void main(String[] args) {
		System.out.println(Districtselect(2));
	}
}
