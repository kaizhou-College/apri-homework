package com.kz.dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.kz.entity.Tbl_fwxx;
import com.opensymphony.xwork2.ActionSupport;

public class FwxxDao extends ActionSupport{
	//分页查询
	public <T> List<T> selByPage(Class clazz,int page,int pageSize,Object uid){
		List<T> list =null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int min = (page-1)*pageSize;
		int max = page*pageSize;
		try {
			conn = BaseDao.getConn();
			String sql  ="select * from" +
					" (select rownum num,t.* from Tbl_fwxx t where uuid=?)" +
					" where num>? and num<=?";
			System.out.println(sql);
			pst = conn.prepareStatement(sql);
			pst.setObject(1, uid);
			pst.setInt(2, min);
			pst.setInt(3,max);
			rs = pst.executeQuery();
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields, true);
			list=new ArrayList<T>();
			while(rs.next()){
				T obj = (T) clazz.newInstance();
				for (Field field : fields) {
					Object value = rs.getObject(field.getName());
					if (value instanceof BigDecimal) {
						if (field.getName().equals("zj")) {
							value=((BigDecimal)value).doubleValue();
						}else{
							value=((BigDecimal)value).intValue();
						}
					}
					if (value instanceof Timestamp) {
						value=((Timestamp)value).toString().substring(0, ((Timestamp)value).toString().lastIndexOf("."));
						
					}
					if (value==null) {
						continue;
					}
					field.set(obj, value);
				}
				
				list.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, pst, conn);
		}
		
		return list;
	}
	//求最大页数
	public <T> int MaxPage(Class clazz,int pageSize,Object uid){
		int num=-1;
		List<T> list =null;
		String sql="select * from Tbl_fwxx where uuid=?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConn();
			pst =conn.prepareStatement(sql);
			pst.setObject(1, uid);
			rs =pst.executeQuery();
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields, true);
			list=new ArrayList<T>();
			while(rs.next()){
				T obj = (T) clazz.newInstance();
				for (Field field : fields) {
					Object value = rs.getObject(field.getName());
					if (value instanceof BigDecimal) {
						if (field.getName().equals("zj")) {
							value=((BigDecimal)value).doubleValue();
						}else{
							value=((BigDecimal)value).intValue();
						}
					}
					if (value instanceof Timestamp) {
						value=((Timestamp)value).toString().substring(0, ((Timestamp)value).toString().lastIndexOf("."));
						
					}
					if (value==null) {
						continue;
					}
					field.set(obj, value);
				}
				
				list.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, pst, conn);
		}
		int size = list.size();
		num=(size-1)/pageSize+1;
	
		return num;
	}
	public static void main(String[] args) {
		FwxxDao fwxxdao=new FwxxDao();
		System.out.println(fwxxdao.selByPage(Tbl_fwxx.class, 1, 2,1));
		System.out.println(fwxxdao.MaxPage(Tbl_fwxx.class,2,1));
	}
}
