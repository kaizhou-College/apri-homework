package pan.dao;

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



import pan.entity.Tbl_fwxx;
import pan.entity.Tbl_user;

public class BaseDao {
	// 链接数据库
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager
					.getConnection("jdbc:oracle:thin://127.0.0.1:1521:orcl",
							"scott", "pyj795");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 断开数据库
	public static void closeConn(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 通用查
	public static List find(Object obj) {
		List list = new ArrayList();
		Class class1 = obj.getClass();
		Field[] fields = class1.getDeclaredFields();
		Field.setAccessible(fields, true);
		StringBuffer buff = new StringBuffer("select ");
		for (int i = 0; i < fields.length; i++) {
			buff.append(fields[i].getName() + ",");
		}
		StringBuffer sql = new StringBuffer(buff
				.substring(0, buff.length() - 1)
				+ " from " + class1.getSimpleName());
		System.out.println(sql.toString());
		Connection conn = getConn();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			while (rs.next()) {
				Object object;
				try {
					object = class1.newInstance();

					for (Field f : fields) {
						Object value = rs.getObject(f.getName());
						if (value instanceof BigDecimal) {
							value = ((BigDecimal) value).intValue();
						}
						if (value instanceof Timestamp) {
							value = ((Timestamp) value).toString();
						}
						if (value == null) {
							continue;
						}
						f.set(object, value);
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
		} finally {
			closeConn(rs, st, conn);
		}

		return list;
	}

	// 修改
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
			} catch (Exception e) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			BaseDao.closeConn(null, pstmt, conn);
		}
		return num;
	}
	// 删除
	public static int delete(Class c, int id) {
		int number = -1;
		StringBuffer sql = new StringBuffer("delete from " + c.getSimpleName()
				+ " where ");
		Field[] fields = c.getDeclaredFields();
		Field.setAccessible(fields, true);
		sql.append(fields[0].getName() + "=?");
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = BaseDao.getConn();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setObject(1, id);
			number = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeConn(null, pstmt, conn);
		}
		 System.out.println(sql.toString());
		return number;
	}

	// 软添加
	public static int insert(String seq, Object obj) {
		int num = -1;
		StringBuffer sql = new StringBuffer("insert into ");
		Class clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		sql.append(clazz.getSimpleName());
		sql.append(" (" + fields[0].getName());
		try {
			for (int i = 1; i < fields.length; i++) {
				if (fields[i].get(obj) != null) {
					sql.append(",");
					sql.append(fields[i].getName());
				}
			}
			sql.append(") values(" + seq + ".nextval");
			for (int i = 1; i < fields.length; i++) {
				if (fields[i].get(obj) != null) {
					sql.append(",?");
				}
			}
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		sql.append(")");
		System.out.println(sql.toString());
		Connection conn = null;
		PreparedStatement st = null;
		try {
			// 获取连接
			conn = BaseDao.getConn();
			// 创建st对象
			st = conn.prepareStatement(sql.toString());
			// 给占位符赋值
			int index = 1;// 占位符的下标 从1开始
			for (int i = 1; i < fields.length; i++) {
				if (fields[i].get(obj) != null) {
					Object value = fields[i].get(obj);
					// 从第1列开始赋值
					st.setObject(index, value);
					index++;
				}
			}
			// 执行添加
			num = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeConn(null, st, conn);
		}
		return num;
	}

	// 分页查询
	public static List selectByPage(int index, int page, Class clazz) {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from (select rownum rn,t.* from "
				+ clazz.getSimpleName() + " t ");
		sql.append("where rownum<=" + index * page + ")");
		sql.append(" where rn>" + (index - 1) * page);
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		// System.out.println(sql.toString());
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeConn(rs, st, conn);
		}
		return list;
	}

	// 得到总页数的方法 总页数=总条数/每页的条数
	public static int getCountPage(Class clazz) {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(*) from " + clazz.getSimpleName());
		// 得到链接
		Connection conn = BaseDao.getConn();
		PreparedStatement st = null;
		ResultSet rs = null;
		int num = -1;
		try {
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			rs.next();
			num = rs.getInt(1);
			// System.out.println("总页数是"+num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeConn(rs, st, conn);
		}
		return num;
	}

	// 得到最大页数
	public static int getMax(int size, Class clazz) {
		double num = getCountPage(clazz) / (size * 1.0);
		int max = (int) Math.ceil(num);
		//System.out.println("最大页数是" + max);
		return max;
	}
/*	//高级查询的最大页
	public static int maxPage(int count,int size) {
		double num = count / (size * 1.0);
		int max = (int) Math.ceil(num);
		return max;
	}*/
	//根据id查询
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

	// 测试
	public static void main(String[] args) {
		BaseDao bd = new BaseDao();
		// 增
		/*
		 * su.setLogonName("测试6"); su.setLogonPwd("123"); su.setUserName("大虾");
		 * su.setSex("男"); su.setTelephone("021-09090097");
		 * su.setEducation("博士"); System.out.println(bd.insert("seq_suer", su));
		 */
		// 删
		// System.out.println(bd.delete(S_User.class,3));
		// 查
		/*
		 * List list=bd.find(S_User.class); for (Object obj : list) { S_User
		 * su=(S_User)obj; System.out.println(su); }
		 */
		// 改
		/*
		 * su.setLogonName("真挚"); su.setUserName("灭顶之灾"); su.setLogonPwd("123");
		 * su.setSex("女"); su.setTelephone("13457677990");
		 * su.setEducation("硕士"); su.setUserID(21);
		 * System.out.println(bd.update(su));
		 */
		// 分页
		/*
		 * Tbl_fwxx tbu = new Tbl_fwxx(); tbu.setFwid(1); System.out.println(new
		 * BaseDao().selectByPage(1, 2,Tbl_fwxx.class));
		 */
	}
}
