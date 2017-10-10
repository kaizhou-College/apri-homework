package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Province;

public class Provincedao {
	public List<Province> listpro(){
		List<Province> list=new ArrayList<Province>();
		Connection conn=Bacedao.getConn();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from province";
		try {
			 pstmt = conn.prepareStatement(sql);
			 rs=pstmt.executeQuery();
			 while(rs.next()){
				 Province pc=new Province();
				 pc.setPid(rs.getInt("pid"));
				 pc.setPname(rs.getString("pname"));
				 list.add(pc);
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			Bacedao.closeConn(rs, pstmt, conn);
		}
		return list;
	}

}
