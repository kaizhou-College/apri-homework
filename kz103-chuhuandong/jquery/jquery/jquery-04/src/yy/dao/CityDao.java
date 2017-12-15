package yy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import yy.entity.City;

public class CityDao {
	public List queryByPid(int id){
		List list =new ArrayList(0);
		String sql = "select * from city where pid = ?";
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs =null;
		try {
			conn = BaseDao.getConn();
			st = conn.prepareStatement(sql);
			st.setInt(1,id);
			rs = st.executeQuery();
			while(rs.next()){
				City a = new City();
				a.setDd(rs.getInt("dd"));
				a.setCname(rs.getString("cname"));
				a.setPid(rs.getInt("pid"));
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
		System.out.println(new CityDao().queryByPid(1));
	}
}
