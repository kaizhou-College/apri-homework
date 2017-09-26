package com.kz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kz.entity.Users;

public class UsersDao {
	public static List<Users> getUsers(){
		List<Users> list = new ArrayList<Users>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getconn();
			String sql = "select * from Users";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				Users user = new Users();
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.CloseConn(rs, pst, conn);
		}
		return list;
	}
	public static List selID(int id){
		Connection conn = BaseDao.getconn();
		PreparedStatement st=null;
		ResultSet rs=null;
		List<Users> list=new ArrayList<Users>();
		try {
			st = conn.prepareCall("select * from users where id=?");
			st.setInt(1,id);
			rs=st.executeQuery();
			while(rs.next()){
				Users u=new Users();
				u.setName(rs.getString("name"));
				u.setPwd(rs.getString("pwd"));
				list.add(u);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static int delete(int id ){
		Connection conn = BaseDao.getconn();
		PreparedStatement st=null;
		int num=0;
		try {
			st=conn.prepareStatement("delete from Users where id = ?");
			st.setInt(1,id);
			num = st.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
		
		
	}
	public static int insert(int id,String name ,String pwd ){
		Connection conn = BaseDao.getconn();
		PreparedStatement st=null;
		int num=0;
		try {
			st=conn.prepareStatement("insert into Users values(?,?,?)");
			st.setInt(1,id );
			st.setString(2,name);
			st.setString(3,pwd);
			num = st.executeUpdate();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
		
		
	}
	public static int Update(int id,String name ,String pwd ){
		Connection conn = BaseDao.getconn();
		PreparedStatement st=null;
		int num=0;
		try {
			st=conn.prepareStatement("Update Users set name=? , pwd=? where id=?");
			
			st.setString(1,name);
			st.setString(2,pwd);
			st.setInt(3,id );
			num = st.executeUpdate();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
		
		
	}
	
	private static Scanner random() {
		return null;
	}
	public static void main(String[] args) {
		List<Users> list = selID(1);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		//System.out.println(delete(2));
		System.out.println(Update(1,"a", "s"));
	}
}
