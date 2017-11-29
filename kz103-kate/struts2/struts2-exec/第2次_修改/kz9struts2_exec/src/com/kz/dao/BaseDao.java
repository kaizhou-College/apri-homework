package com.kz.dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.kz.entity.QueryUser;
import com.kz.entity.User;
public class BaseDao{
	public static Connection getConn(){
		Connection conn=null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=struts2Exmp", "sa", "123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConn(ResultSet rs,Statement st,Connection conn){
		
			try {
				if (rs!=null) {
					rs.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (st!=null) {
					st.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (conn!=null) {
					conn.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	//通用的分页查询
	public <T> List<T> selByPage(Class clazz,int page,int pageSize,QueryUser qu){
		List<T> list =null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			StringBuffer sb = new StringBuffer(" select top (?) t.* from (select * from s_user where 1=1 ");
			buildCretira(sb, qu);
			sb.append(" ) t");
			sb.append(" where userid not in (select top (?) t1.userid from (select * from s_user where 1=1 ");
			buildCretira(sb, qu);
			sb.append(" ) t1)");
			//System.out.println("sql===="+sb.toString());
			pst = conn.prepareStatement(sb.toString());
			pst.setInt(1, pageSize);
			pst.setInt(2,pageSize*(page-1));
			rs = pst.executeQuery();
			Field[] fields = clazz.getDeclaredFields();
			Field.setAccessible(fields, true);
			list=new ArrayList<T>();
			while(rs.next()){
				T obj = (T) clazz.newInstance();
				for (Field field : fields) {
					Object value = rs.getObject(field.getName());
					if (value instanceof BigDecimal) {
						value=((BigDecimal)value).intValue();
					}
					if (value instanceof Timestamp) {
						value = ((Timestamp)value).toString();
						//value = (Timestamp)value;
					}
					if (value==null) {
						continue;
					}
					field.set(obj, value);
				}
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, pst, conn);
		}
		return list;
	}	
	public StringBuffer buildCretira(StringBuffer sb,QueryUser qu){
		if(qu.getUserName()!=null&&qu.getUserName().trim().length()>0){
			sb.append(" and username like '%"+qu.getUserName()+"%'");
		}
		if(qu.getSex()!=null&&qu.getSex().trim().length()>0){
			sb.append(" and sex='"+qu.getSex()+"'");
		}
		if(qu.getEducation()!=null&&qu.getEducation().trim().length()>0){
			sb.append(" and education='"+qu.getEducation()+"'");
		}
		if(qu.getIsUpload()==false){
			sb.append(" and filename is null ");
		}else{
			sb.append(" and filename is not null ");
		}
		return sb;
	}
	//获取最大页数通用
	public <T> int getMax(T t,int pageSize,QueryUser qu){
		Connection conn= getConn();
		PreparedStatement st = null;
		ResultSet rs = null;
		int size = 0;
		int max = 0;
		StringBuffer sb =new StringBuffer("select count(t.userid) from (");
		sb.append(" select * from s_user where 1=1 ");
		buildCretira(sb, qu);
		sb.append(" ) t");
		//System.out.println("sql="+sb.toString());
		
		try {
			st = conn.prepareStatement(sb.toString());
			rs = st.executeQuery();
			while(rs.next()){
				size = rs.getInt(1);
			}
			max = (size-1)/pageSize+1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeConn(rs, st, conn);
		}
		
		return max;
	}
	public static void main(String[] args) {
		QueryUser qu = new QueryUser();
		qu.setUserName("二");
		qu.setIsUpload(1);
		System.out.println(new BaseDao().selByPage(User.class, 1, 2, qu ));
		System.out.println(new BaseDao().getMax(User.class, 2, qu));
	}
}
