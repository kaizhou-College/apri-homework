package com.kz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.kz.entity.Users;
public class UsersDao {
	public List<Users> findByPage(int page,int rows){
		List<Users> users = new ArrayList<Users>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		try {
			String sql = "select * from (select rownum rn,p.* from users p)" +
					" where rn>"+(page-1)*rows+" and rn<="+page*rows;
			conn = BaseDao.getConn();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				Users u = new Users();
				u.setId(rs.getLong("id"));
				u.setName(rs.getString("uname"));
				u.setSex(rs.getString("sex"));
				u.setAge(rs.getLong("age"));
				u.setSalary(rs.getDouble("salary"));
				//放入集合
				users.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, pst, conn);
		}
		return users ;
	}
	public static void main(String[] args) {
		System.out.println(new UsersDao().findByPage(2, 3));
	}
}
