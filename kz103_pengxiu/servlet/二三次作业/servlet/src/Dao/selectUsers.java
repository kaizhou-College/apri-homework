package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executor;

import entity.Users;
import entity.book;

public class selectUsers {
	public static List sel(String user,String password,String name,String pwd){
		Connection conn = BaseDao.getconn(user, password);
		PreparedStatement st=null;
		ResultSet rs=null;
		List<Users> list=new ArrayList();
		try {
			st = conn.prepareCall("select * from users where name = ? and pwd =? ");
			st.setString(1,name);
			st.setString(2,pwd);
			rs=st.executeQuery();
			while(rs.next()){
				Users u=new Users();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPwd(rs.getString("pwd"));
				list.add(u);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
	public static List selID(int id){
		Connection conn = BaseDao.getconn("scott", "orcl");
		PreparedStatement st=null;
		ResultSet rs=null;
		List<Users> list=new ArrayList();
		try {
			st = conn.prepareCall("select * from users where id=?");
			st.setInt(1,id);
			rs=st.executeQuery();
			while(rs.next()){
				Users u=new Users();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPwd(rs.getString("pwd"));
				list.add(u);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static int delete(int id ){
		Connection conn = BaseDao.getconn("scott", "orcl");
		PreparedStatement st=null;
		int num=0;
		try {
			st=conn.prepareStatement("delete from Users where id = ?");
			st.setInt(1,id);
			num = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
		
		
	}
	public static int insert(int id,String name ,String pwd ){
		Connection conn = BaseDao.getconn("scott", "orcl");
		PreparedStatement st=null;
		int num=0;
		try {
			st=conn.prepareStatement("insert into Users values(?,?,?)");
			st.setInt(1,id );
			st.setString(2,name);
			st.setString(3,pwd);
			num = st.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
		
		
	}
	public static int Update(int id,String name ,String pwd ){
		Connection conn = BaseDao.getconn("scott", "orcl");
		PreparedStatement st=null;
		int num=0;
		try {
			st=conn.prepareStatement("Update Users set name=? , pwd=? where id=?");
			
			st.setString(1,name);
			st.setString(2,pwd);
			st.setInt(3,id );
			num = st.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
		
		
	}
	
	private static Scanner random() {
		// TODO Auto-generated method stub
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
