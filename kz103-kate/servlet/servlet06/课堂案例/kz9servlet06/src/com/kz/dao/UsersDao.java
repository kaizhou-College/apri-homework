package com.kz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.registry.infomodel.User;

import com.kz.entity.Users;



public class UsersDao {

	public boolean val(String uname){
		boolean flag = false;//默认表示不存在
		
		Connection conn = BaseDao.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from users where uname='"+uname+"'";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int count = rs.getInt(1);
				flag = count>0?true:false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(rs, pstmt, conn);
		}
		return flag;
	}
	
	
	public List<Users> find(String uname){
		List<Users> list = new ArrayList<Users>();
		Connection conn = BaseDao.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from users where uname like '%"+uname+"%'";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Users u = new Users();
				u.setId(rs.getInt("id"));
				u.setUname(rs.getString("uname"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(rs, pstmt, conn);
		}
		return list;
	}
	public static void main(String[] args) {
		for(Users u :new UsersDao().find("二")){
			System.out.println(u);
		}
	}
}
