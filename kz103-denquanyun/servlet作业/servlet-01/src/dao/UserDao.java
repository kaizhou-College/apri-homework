package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.UserInfo;

public class UserDao {
	public static UserInfo query(String name,String password){
		UserInfo user = null;
		Connection conn = null;
		PreparedStatement pst=null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConn();
			String sql = "select * from users where name=? and password=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1,name);
			pst.setString(2,password);
			rs = pst.executeQuery();
			while(rs.next()){
				user = new UserInfo();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, pst, conn);
		}
		
		return user;
	}
	public static int deleteById(int id){
		Connection conn = null;
		PreparedStatement pst = null;
		int num = -1;
		try {
			conn = BaseDao.getConn();
			String sql = "delete from users where id=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1,id);
			num = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, pst, conn);
		}
		return num;
	}
	public static int Add(UserInfo user){
		Connection conn = null;
		PreparedStatement pst = null;
		int num = -1;
		try {
			conn = BaseDao.getConn();
			String sql = "insert into users values(?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1,user.getName());
			pst.setString(2,user.getPassword());
			num = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(null, pst, conn);
		}
		return num;
	}
}
