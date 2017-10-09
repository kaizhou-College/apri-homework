package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Province;

public class ProvinceDao {
	public List<Province> listPro(){
		List<Province> list = new ArrayList<Province>();
		
		Connection conn = BaseDao.getConn();
		PreparedStatement pstmt = null;
		String sql = " select * from province";
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Province pc = new Province();
				pc.setPid(rs.getInt("pid"));
				pc.setPname(rs.getString("name"));
				list.add(pc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(rs, pstmt, conn);
		}
		return list;
	}
	public static void main(String[] args) {
		for(Province p :new ProvinceDao().listPro()){
			System.out.println(p);
		}
	}
}	
