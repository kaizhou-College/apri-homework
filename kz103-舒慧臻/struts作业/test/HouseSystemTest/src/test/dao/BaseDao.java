package test.dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


import test.entity.Tbl_Fwlx;
import test.entity.Tbl_Fwxx;
import test.entity.Tbl_User;

public class BaseDao {
	// 链接数据库
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager
					.getConnection("jdbc:oracle:thin://127.0.0.1:1521:orcl",
							"scott", "abc");
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
	//通用查
	public static List find(Class class1){
		List list=new ArrayList();
		Field[] fields = class1.getDeclaredFields();
		Field.setAccessible(fields,true);
		StringBuffer buff=new StringBuffer("select ");
		for (int i = 0; i < fields.length; i++) {
			buff.append(fields[i].getName()+",");
		}
		StringBuffer sql=new StringBuffer(buff.substring(0,buff.length()-1)+" from "+class1.getSimpleName());
		System.out.println(sql.toString());
		Connection conn = getConn();
		PreparedStatement st=null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			while(rs.next()){
				Object object;
				try {
					object = class1.newInstance();
				
				for(Field f:fields){
					Object value = rs.getObject(f.getName());
					if(value instanceof BigDecimal){
						value=((BigDecimal)value).intValue();
					}
					if(value instanceof Timestamp){
						value=((Timestamp)value).toString();
					}
					if(value==null){
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
		}finally{
			closeConn(rs, st, conn);
		}
		
		return list;
	}
	//修改
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
						pstmt.setObject(index, value);
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
		}finally {
			BaseDao.closeConn(null, pstmt, conn);
		}
		return num;
	}
    //文件上传 随机数新名字
/*	public static String getNewFileName(String oldFile){
    	String uuid = UUID.randomUUID().toString();
    	String newName =uuid+oldFile.substring(oldFile.lastIndexOf(".")); //uuid+后缀
    	return newName;
    }*/
	// 根据id查询
	public static Object queryById(Class clazz, int id) {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from ");
		sql.append(clazz.getSimpleName());
		sql.append(" where ");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		sql.append(fields[0].getName()+"="+id);
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Object obj = null;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql.toString());
			// 给占位符赋值
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
	public static List ReQueryById(Class clazz, Object id) {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from ");
		sql.append(clazz.getSimpleName());
		sql.append(" where ");
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		List list = new ArrayList(0);
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
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BaseDao.closeConn(rs, st, conn);
		}
		return list;
	}
	
	//删除
	public static int delete(Class c,int id){
		int number=-1;
		StringBuffer sql=new StringBuffer("delete from "+c.getSimpleName()+" where ");
		Field[] fields = c.getDeclaredFields();
		Field.setAccessible(fields, true);
		sql.append(fields[0].getName()+"=?");
		Connection conn = null;
		PreparedStatement pstmt =null;
		try {
			conn = BaseDao.getConn();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setObject(1,id);
			number = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, pstmt, conn);
		}
		//System.out.println(sql.toString());
		return number;
	}
	//软添加
	public static int insert(String seq,Object obj){
		int num = -1;
		StringBuffer sql  = new StringBuffer("insert into ");
		Class clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		sql.append(clazz.getSimpleName());
		sql.append("("+fields[0].getName());
		try {
			for(int i=1;i<fields.length;i++){
				if(fields[i].get(obj)!=null){
					sql.append(",");
					sql.append(fields[i].getName());
				}
			}
			sql.append(") values("+seq+".nextval");
			for(int i=1;i<fields.length;i++){
				if(fields[i].get(obj)!=null){
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
			//获取连接
			conn = BaseDao.getConn();
			//创建st对象
			st = conn.prepareStatement(sql.toString());
			//给占位符赋值
			int index = 1;//占位符的下标 从1开始
			for(int i=1;i<fields.length;i++){
				if(fields[i].get(obj)!=null){
					Object value = fields[i].get(obj);
					//从第1列开始赋值
					st.setObject(index, value);
					index++;
				}
			}
			// 执行添加
			num = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, st, conn);
		}
		return num;
	}
	
	//分页查询
	public static List selectByPage(int index,int page,Class clazz){
		StringBuffer sql =new StringBuffer();
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields,true);
		sql.append("select * from (select rownum rn,t.* from "+clazz.getSimpleName()+" t ");
		sql.append("where rownum<="+index*page+")");
		sql.append(" where rn>"+(page-1)*index);
		System.out.println(sql.toString());
		List list = new ArrayList(0);
		Connection conn = BaseDao.getConn();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql.toString());
			rs = st.executeQuery();
			while(rs.next()){
				Object obj = clazz.newInstance();
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
					field.set(obj, value);
				}
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return list;
	}
	//最大页数
	public static int getMax(Class clazz,int pageSize){
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int max = 0;
		try {
			conn = getConn();
			String sql = "select count(*) from Tbl_Fwxx";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			rs.next();
			int size = rs.getInt(1);
			max = (size-1)/pageSize+1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConn(rs, st, conn);
		}
		return max;
	}
	public static void main(String[] args) {
//		System.out.println(getConn());
		//添加
		Tbl_User user = new Tbl_User();
//		user.setUname("哪吒");
//		user.setUpass("777");
//		System.out.println(insert("seq_user", user));
		Tbl_Fwxx fw = new Tbl_Fwxx();
//		List list = selectByPage(1, 3, fw.getClass());
//		System.out.println(list);
//		System.out.println(new BaseDao().getMax(Tbl_Fwxx.class, 3));
//		List list = ReQueryById(Tbl_Fwxx.class, 1);
//		System.out.println(list);
//		System.out.println(new BaseDao().find(Tbl_Fwxx.class));
//		System.out.println(new BaseDao().queryById(Tbl_User.class, 3));
//分页
		System.out.println(new BaseDao().selectByPage(3, 1, Tbl_Fwxx.class));
	
	}
}
