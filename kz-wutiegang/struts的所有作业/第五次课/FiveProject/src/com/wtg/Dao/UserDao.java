package com.wtg.Dao;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.wtg.entity.AuctionUser;


public class UserDao {
	
	//判断用户是不是管理员
	public static boolean isAdmin(String username,String userpassword){
		try {
			AuctionUser actionuser = load(AuctionUser.class, username, userpassword);
			if (actionuser.getUserisadmin()==1) {
				return true;
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//新增
	public static <T> int add(String seq,T t) throws IllegalArgumentException, IllegalAccessException{
		int num=-1;
		Class clazz = t.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Field.setAccessible(fields, true);
		StringBuffer sql=new StringBuffer("insert into "+clazz.getSimpleName()+"(");
		sql.append(fields[0].getName()+",");
		for (int i = 0; i < fields.length; i++) {
			String name = fields[i].getName();
			if (fields[i].get(t)!=null&&!fields[i].get(t).equals(new Integer(0))) {
				sql.append(name+",");
				
			}
			
		}
		sql  =new StringBuffer(sql.substring(0, sql.length()-1));
		sql.append(") values("+seq+".nextval");
		for (int i = 0; i < fields.length; i++) {
			try {
				if (fields[i].get(t)!=null&&!fields[i].get(t).equals((new Integer(0)))) {
					sql.append(",?");
					
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
		System.out.println(sql.toString());
		Connection conn = BaseDao.getConn();
		PreparedStatement st=null;
		try {
			st=conn.prepareStatement(sql.toString());
			int index=1;
			for (int i = 1; i < fields.length; i++) {
			 Object value = fields[i].get(t);
			 if (fields[i].get(t)!=null&&!fields[i].get(t).equals((new Integer(0)))) {
				
				 	st.setObject(index, value);
					index++;
					
				}
			}
			num = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, conn, st);
		}
		return num;
	}
	//根据用户名和密码查询是否是管理员
	public static AuctionUser load(Class c,String username , String userpassword) throws InstantiationException, IllegalAccessException {
		AuctionUser actionuser =null;
		StringBuffer sql=new StringBuffer("select ");
		//得到所有的属性
		Field[] fields = c.getDeclaredFields();
		Field.setAccessible(fields, true);
		//把需要的属性拼接到sql上并且用，号隔开
		for (int i = 0; i < fields.length; i++) {
			sql.append(fields[i].getName());
			if (i!=fields.length-1) {
				sql.append(",");
			}
		}
		sql.append(" from "+c.getSimpleName()+" where "+fields[1].getName()+"=? and "+fields[2].getName()+"=?");
		System.out.println(sql.toString()); 
		//连接数据库
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		
		try {
			conn = BaseDao.getConn();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, username);
			pstmt.setString(2, userpassword);
			rs = pstmt.executeQuery();
			while(rs.next()){
				actionuser = (AuctionUser) c.newInstance();
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
					field.set(actionuser, value);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, conn, pstmt);
		}
		
		
		return actionuser;
	}
	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException {
		/*AuctionUser au=new AuctionUser();
		au.setUsername("二狗子");
		au.setUserpassword("123");
		System.out.println(new UserDao().add(au));*/
		System.out.println(UserDao.isAdmin("王小san", "30"));
		
	}
}
