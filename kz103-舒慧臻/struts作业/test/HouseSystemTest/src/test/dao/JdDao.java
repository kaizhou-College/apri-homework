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

import test.entity.Tbl_Jd;

public class JdDao {
	//根据id查两表联查
	public List findById1(Class clazz, int id) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List list = new ArrayList(0);
		try {
			conn = BaseDao.getConn();
			/*
			 * select a.qxid,jdid,jd,b.qx from Tbl_Jd a 
			       inner join Tbl_Qx b
			       on a.qxid = b.qxid
			       where jdid=2 
			 */
			String sql = "select a.qxid,jdid,jd,b.qx from Tbl_Jd a inner join Tbl_Qx b"
						+" on a.qxid = b.qxid"+" where jdid="+id;
			System.out.println(sql.toString());
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields, true);
			while(rs.next()){
				Object obj = clazz.newInstance();
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
					field.set(obj, value);
				}
				list.add(obj);
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
		
		return list;
	}
	//根据房屋信息ID查询街道ID
	public static int queryById(int id) {
		StringBuffer sql = new StringBuffer();
		sql.append("select jdid from Tbl_Fwxx");
		sql.append(" where ");
		sql.append("fwid=?");
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int num = 0 ;
			try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql.toString());
			// 给占位符赋值
			st.setInt(1, id);
			rs = st.executeQuery();
			while (rs.next()) {
				if(rs!=null){
					num = rs.getInt(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeConn(rs, st, conn);
		}
		return num;
	}
	public static void main(String[] args) {
		System.out.println(new JdDao().findById1(Tbl_Jd.class, 2));
//		System.out.println(new JdDao().queryById(2));
	}
}
