package yy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import yy.entity.City;
import yy.entity.District;

public class DistrictDao {
	public List queryByCid(int id){
		List list =new ArrayList(0);
		String sql = "select * from district where cid = ?";
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs =null;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql);
			st.setInt(1,id);
			rs = st.executeQuery();
			while(rs.next()){
				District a = new District();
				a.setDid(rs.getInt("did"));
				a.setDname(rs.getString("dname"));
				a.setCid(rs.getInt("cid"));
				list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, st, conn);
		}
		return list;
	}
	public static void main(String[] args) {
		System.out.println(new DistrictDao().queryByCid(1));
	}
}
