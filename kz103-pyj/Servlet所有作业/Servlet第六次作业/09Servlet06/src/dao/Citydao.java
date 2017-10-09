package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.City;

public class Citydao {
	public List<City> Byid(int pid){
		List<City> list=new ArrayList<City>();
		Connection conn=Bacedao.getConn();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from city where pid="+pid;
		try {
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				City city=new City();
				city.setCid(rs.getInt("cid"));
				city.setCname(rs.getString("cname"));
				city.setPid(rs.getInt("pid"));
				list.add(city);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Bacedao.closeConn(rs, pstmt, conn);
		}
		return list;
	}
}
