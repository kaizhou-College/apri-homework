package com.kz.dao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.kz.entity.TeacherInfo;

public class TeacherDao {
	public static List<Object> find(Class cls){
		List<Object> list = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		Field[] Teachers = cls.getDeclaredFields();
		Field.setAccessible(Teachers, true);
		for (int i = 0; i < Teachers.length; i++) {
			sql.append(Teachers[i].getName());
			if(i!=Teachers.length-1){
				sql.append(",");
				
			}
		}
		sql.append(" from "+cls.getSimpleName());
		Connection con = BaseDao.Getconn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = con.prepareStatement(sql.toString());
			rs = pst.executeQuery();
			while(rs.next()){
				Object obj = null;
				try {
					obj = cls.newInstance();
				} catch (Exception e) {
					e.printStackTrace();
				}
				for(Field f:Teachers){
					Object value = rs.getObject(f.getName());
					if(value instanceof BigDecimal){
						value = ((BigDecimal)value).intValue();
					}
					if(value instanceof Timestamp){
						value = ((Timestamp)value).toString();
					}
					if(value==null){
						continue;
					}
					try {
						f.set(obj, value);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.Close(rs, pst, con);
		}
		return list;
	}
	public static int save(Object obj){
//		insert into teacherinfo values(3,'êPÓð','13375453322','gy@gmail.com')
		int num = -1;
		Class cls = obj.getClass();
		Field[] fields = cls.getDeclaredFields();
		Field.setAccessible(fields, true);
		StringBuffer sql = new StringBuffer();
		sql.append("insert into "+cls.getSimpleName()+" values(");
			for (int i = 0; i < fields.length; i++) {
				sql.append("?");
				if(i!=fields.length-1){
					sql.append(",");
				}
			}
		sql.append(")");
		Connection con = BaseDao.Getconn();
		PreparedStatement st = null;
		try {
			st = con.prepareStatement(sql.toString());
			int index = 1;
			for (int i = 0; i < fields.length; i++) {
				try {
					st.setObject(index,fields[i].get(obj));
				} catch (Exception e) {
					e.printStackTrace();
				}
				index++;
			}
			num = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.Close(null, st, con);
		}
		return num;
	}
	public static int delete(Class cls,int id){
		//delete form teacherinfo where id=?
		int num = -1;
		StringBuffer sql = new StringBuffer();
		sql.append("delete from "+cls.getSimpleName()+" where ");
		Field[] fields = cls.getDeclaredFields();
		sql.append(fields[0].getName()+"=?");
		System.out.println(sql);
		Connection con = BaseDao.Getconn();
		PreparedStatement st = null;
		try {
			st = con.prepareStatement(sql.toString());
			st.setInt(1, id);
			num = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.Close(null, st, con);
		}
		return num;
	}
	public static int update(Object obj){
//		update teacherinfo set teachername='ŒO™à',teachertel='13354564488',teacheremail='sq@sina.cm' where teacherid='4'
		int num = -1;
		Class cls = obj.getClass();
		Field[] fields = cls.getDeclaredFields();
		Field.setAccessible(fields, true);
		StringBuffer sql = new StringBuffer();
		sql.append("update "+cls.getSimpleName()+" set ");
			for (int i = 0; i < fields.length; i++) {
				if(i!=0){
					try {
						if(fields[i].get(obj)!=null){
							sql.append(fields[i].getName());
							sql.append("=?");
							if(i!=fields.length-1){
								sql.append(",");
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			try {
				if(fields[fields.length-1].get(obj)==null){
					sql = new StringBuffer(sql.substring(0, sql.length()-1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		sql.append(" where "+fields[0].getName()+"=?");
		System.out.println(sql);
		Connection con = BaseDao.Getconn();
		PreparedStatement st = null;
		try {
			st = con.prepareStatement(sql.toString());
			int index = 1;
			for (int i = 0; i < fields.length; i++) {
				try {
					if(i!=0){
						System.out.println(index+"---"+fields[i].get(obj));
						if(fields[i].get(obj)!=null){
							st.setObject(index,fields[i].get(obj));
							index++;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			try {
				st.setObject(index, fields[0].get(obj));
				System.out.println(index+"---"+fields[0].get(obj));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			num = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.Close(null, st, con);
		}
		return num;
	}
	public static Object load(Class cls,int id){
		Object obj = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select ");
		Field[] Teachers = cls.getDeclaredFields();
		Field.setAccessible(Teachers, true);
		for (int i = 0; i < Teachers.length; i++) {
			sql.append(Teachers[i].getName());
			if(i!=Teachers.length-1){
				sql.append(",");
			}
		}
		sql.append(" from "+cls.getSimpleName()+" where "+Teachers[0].getName()+"=?");
		Connection con = BaseDao.Getconn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = con.prepareStatement(sql.toString());
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()){
				try {
					obj = cls.newInstance();
				} catch (Exception e) {
					e.printStackTrace();
				}
				for(Field f:Teachers){
					Object value = rs.getObject(f.getName());
					if(value instanceof BigDecimal){
						value = ((BigDecimal)value).intValue();
					}
					if(value instanceof Timestamp){
						value = ((Timestamp)value).toString();
					}
					if(value==null){
						continue;
					}
					try {
						f.set(obj, value);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.Close(rs, pst, con);
		}
		return obj;
	}
//œyÔ‡	
//	public static void ss(Object obj) throws IllegalArgumentException, IllegalAccessException{
//		Class cls = obj.getClass();
//		StringBuffer sql = new StringBuffer();
//		sql.append("delete form "+cls.getSimpleName()+" where ");
//		Field[] fields = cls.getDeclaredFields();
//		sql.append(fields[0].getName()+"=?");
//		System.out.println(sql);
//	}
	public static void main(String[] args) throws Exception {
		Class cls = Class.forName("com.kz.entity.TeacherInfo");
		TeacherInfo obj = (TeacherInfo) cls.newInstance();
//		obj.setTeacheremail("aaa");
//		obj.setTeacherid(4);
//		obj.setTeachername("hhaa");
//		obj.setTeachertel("18385399655");
//		update(obj);
//		System.out.println(load(cls, 4));
	}
}
