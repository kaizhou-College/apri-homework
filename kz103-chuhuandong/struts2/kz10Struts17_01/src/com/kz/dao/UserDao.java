package com.kz.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kz.entity.Users;

public class UserDao {
	public static int addUser(Users user){
		int num = -1;
		Connection conn = BaseDao.getConn();
		String sql = "insert into Users values(?,?,sysdate)";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2, user.getPwd());
			num = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.Close(null, pst, conn);
		}
		return num;
	}
	public static int Delete(String name){
		int num = -1;
		Connection conn = BaseDao.getConn();
		String sql = "delete from Users where name=?";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			num = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.Close(null, pst, conn);
		}
		return num;
	}
	public static List<Users> showUser(){
		List<Users> list = new ArrayList<Users>();
		Connection conn = BaseDao.getConn();
		String sql = "select * from Users";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				Users user =new Users();
				user.setBrithday(rs.getDate("brithday"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.Close(rs, pst, conn);
		}
		return list;
	}
	public static void main(String[] args) {
		Users user = new Users();
		user.setBrithday(new Date(0));
		user.setName("date");
		user.setPwd("date");
		addUser(user);
	}
}
