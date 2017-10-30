package struts3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import struts3.entity.Orders;
import struts3.entity.Users1;

public class UsersDao {
	public Boolean findByNp(Users1 user){
		Connection conn = BaseDao.getConn();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			String sql = "select count(*) from Users1 where username = ? and userpwd=?";
			st = conn.prepareStatement(sql);
			st.setString(1, user.getUsername());
			st.setString(2, user.getUserpwd());
			rs = st.executeQuery();
			while(rs.next()){
				int num = rs.getInt(1);
				if(num>0){
					return true;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return false;
	}
	
	
/*	public int update(Orders or,int id){
		int num = -1;
		Connection conn = BaseDao.getConn();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "update Orders set custname=?,prodname=?,ordercount=?,orderdate=? where ordered="+id;
			st = conn.prepareStatement(sql);
			st.setString(1, or.getCustname());
			st.setString(2, or.getProdname());
			st.setDouble(3, or.getOrdercount());
			st.setString(4, or.getOrderdate());
			num = st.executeUpdate();
			if(num >1){
				System.out.println(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return num;
	}*/
	public static void main(String[] args) {
		Users1 user = new Users1();
//		user.setUsername("鲁智深");
//		user.setUserpwd("12324");
//		System.out.println(new UsersDao().findByNp(user));
		/*Orders or = new Orders();
		or.setCustname("简单");
		or.setOrdercount(900);
		or.setOrderdate("5-12月-17");
		or.setProdname("江南皮革厂");
		System.out.println(new UsersDao().update(or, 3));*/
		
	}

}
