package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Tbl_User;

public class UserDao {
	public Tbl_User queryLogin(String name,String pwd){
		Tbl_User user = null;
		String sql = "select * from tbl_user where uname=? and upass=?";
		Connection conn = null;
		PreparedStatement st =null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql);
			st.setString(1,name);
			st.setString(2,pwd);
			rs = st.executeQuery();
			if(rs.next()){
				user = new Tbl_User();
				user.setUname(rs.getString("uname"));
				user.setUpass(rs.getString("upass"));
				user.setUuid(rs.getInt("uuid"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return user;
	}
	public static void main(String[] args) {
		System.out.println(new UserDao().queryLogin("оие╝","123"));
	}
}
