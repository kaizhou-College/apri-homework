package dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import entity.Tbl_Fwxx;
import entity.Tbl_Jd;

public class BaseDao {
	// ��������
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:127.0.0.1:1521:orcl", "scott", "abc");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	// �ر�����
	public static void closeConn(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// ��ѯ����
	public static List queryAll(Class clazz) {
		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		for (int i = 0; i < fields.length; i++) {
			sql.append(fields[i].getName());

			if (i < fields.length - 1) {
				sql.append(",");
			}
		}
		sql.append(" from " + clazz.getSimpleName());
		System.out.println(sql.toString());
		// ��������
		List list = new ArrayList(0);
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			while (rs.next()) {
				Object obj = clazz.newInstance();
				for (int i = 0; i < fields.length; i++) {
					Object value = rs.getObject(fields[i].getName());
					if (value instanceof BigDecimal) {
						value = ((BigDecimal) value).intValue();
					}
					if (value instanceof Timestamp) {
						value = ((Timestamp) value).toString();
					}
					if (value == null) {
						continue;
					}
					fields[i].set(obj, value);
				}
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeConn(rs, st, conn);
		}
		return list;
	}
	// ���
	public static int insert(String seq, Object obj) {
		int num = -1;
		StringBuffer sql = new StringBuffer("insert into ");
		Class clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		sql.append(clazz.getSimpleName());
		sql.append(" (" + fields[0].getName());
		for (int i = 1; i < fields.length; i++) {
			try {
				if (fields[i].get(obj) != null
						&& !fields[i].get(obj).equals(new Integer(0))
						&& !fields[i].get(obj).equals(new Double(0.0))) {
					sql.append(",");
					sql.append(fields[i].getName());
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sql.append(") values(" + seq + ".nextval");
		for (int i = 1; i < fields.length; i++) {
			try {
				if (fields[i].get(obj) != null
						&& !fields[i].get(obj).equals(new Integer(0))
						&& !fields[i].get(obj).equals(new Double(0.0))) {
					if (fields[i].getName().contains("date")) {
						sql.append(",to_date(?,'yyyy-MM-dd')");
					} else {
						sql.append(",?");
					}
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sql.append(")");
		Connection conn = null;
		PreparedStatement st = null;
		try {
			// 1,��ȡ����
			conn = BaseDao.getConn();
			// 2,����statement����
			st = conn.prepareStatement(sql.toString());
			// 3,��ռλ����ֵ
			int index = 1;// ռλ�����±� ��1��ʼ
			for (int i = 1; i < fields.length; i++) {
				if (fields[i].get(obj) != null
						&& !fields[i].get(obj).equals(new Integer(0))
						&& !fields[i].get(obj).equals(new Double(0.0))) {
					Object value = fields[i].get(obj);
					// �ӵ�1�п�ʼ��ֵ
					st.setObject(index, value);
					index++;
				}
			}
			// 4, ִ�����
			num = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeConn(null, st, conn);
		}
		System.out.println(sql.toString());
		return num;
	}
	// ɾ��
	public static int del(Class clazz, int id) {
		StringBuffer sql = new StringBuffer();
		// delete from ���� where id = ?;
		sql.append("delete from ");
		Connection conn = BaseDao.getConn();
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		sql.append(clazz.getSimpleName() + " where " + fields[0].getName()
				+ "=" + id);
		PreparedStatement st = null;
		int num = -1;
		try {
			st = conn.prepareStatement(sql.toString());
			num = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sql.toString());
		return num;
	}
	// ����id��ѯ
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
			// ��ռλ����ֵ
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
	// ��ҳ��ѯ
	public static List queryByPage(int index, int page, Class clazz) {
		/*
		 * SELECT * FROM (SELECT ROWNUM rn ,e.* FROM emp e WHERE
		 * ROWNUM<=index*page) WHERE rn>index-1*page;
		 */
		StringBuffer sql = new StringBuffer();
		sql.append("select * from (select rownum rn,t.* from "
				+ clazz.getSimpleName() + " t ");
		sql.append("where rownum<=" + index * page + ")");
		sql.append(" where rn>" + (index - 1) * page);
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		System.out.println(sql.toString());
		// ��������
		List list = new ArrayList(0);
		Connection conn = BaseDao.getConn();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			while (rs.next()) {
				Object obj = clazz.newInstance();
				for (int i = 0; i < fields.length; i++) {
					Object value = rs.getObject(fields[i].getName());
					if (value instanceof BigDecimal) {
						value = ((BigDecimal) value).intValue();
					}
					if (value instanceof Timestamp) {
						value = ((Timestamp) value).toString();
					}
					if (value == null) {
						continue;
					}
					fields[i].set(obj, value);
				}
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeConn(rs, st, conn);
		}
		return list;
	}
	// �õ�����
	public static int getCount(Class clazz) {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from " + clazz.getSimpleName());
		// �õ�����
		Connection conn = BaseDao.getConn();
		PreparedStatement st = null;
		ResultSet rs = null;
		int num = -1;
		try {
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			rs.next();
			num = rs.getInt(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeConn(rs, st, conn);
		}
		return num;
	}
	// �õ������
	public static int getMax(int count,int size) {
		double num = count / (size * 1.0);
		int max = (int) Math.ceil(num);
		return max;
	}
	// �޸�
	public static int update(Object o) {
		int num = -1;
		StringBuffer sql = new StringBuffer("update ");
		Class c = o.getClass();
		sql.append(c.getSimpleName() + " set ");
		Field[] fields = c.getDeclaredFields();
		Field.setAccessible(fields, true);
		int count = 0;
		for (int i = 1; i < fields.length; i++) {
			try {
				if (fields[i].get(o) != null) {
					count++;
					if (fields[i].getName().contains("date")) {
						sql.append(fields[i].getName()
								+ "=to_date(?,'yyyy-MM-dd')");
					} else {
						sql.append(fields[i].getName() + "=?");
					}

					if (i != fields.length - 1) {
						sql.append(",");
					}
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (sql.substring(sql.length() - 1, sql.length()).equals(",")) {
			sql = new StringBuffer(sql.substring(0, sql.length() - 1));
		}
		sql.append(" where ");
		sql.append(fields[0].getName() + "=?");
		System.out.println(sql.toString());

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = BaseDao.getConn();
			pstmt = conn.prepareStatement(sql.toString());
			int index = 0;
			for (int i = 1; i < fields.length; i++) {
				Object value = fields[i].get(o);
				if (value != null) {
					index++;
					if (fields[i].getName().contains("date")) {
						SimpleDateFormat sdf = new SimpleDateFormat(
								"yyyy-MM-dd");
						Date date = sdf.parse((String) value);
						String str = sdf.format(date);
						pstmt.setObject(index, str);
					} else {
						pstmt.setObject(index, value);
					}
				}
			}
			pstmt.setObject(index + 1, fields[0].get(o));
			num = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDao.closeConn(null, pstmt, conn);
		}
		return num;
	}
    //�ļ��ϴ� �����������
	public static String getNewFileName(String oldFile){
    	String uuid = UUID.randomUUID().toString();
    	String newName =uuid+oldFile.substring(oldFile.lastIndexOf(".")); //uuid+��׺
    	return newName;
    }
	public static void main(String[] args) {
		 Date date = new Date();
		 Timestamp time = new Timestamp(date.getTime());
		 String substring = time.toString().substring(0,time.toString().lastIndexOf(" "));
		 System.out.println(substring);
		 Tbl_Fwxx fw = new Tbl_Fwxx();
		 fw.setPublishdate(time.toString());
		 BaseDao.insert("message_id",substring);
//		 FwxxView [fwlx=ë��, fwxx=������, jd=��ɽ, lxr=��, qx=����, shi=1, time=2017-11-28 09:35:55.46, ting=1, title=�������Ҳ�����, zj=1]
	}
}
