package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.City;
import entity.Constellation;

public class Constellationdao {
	public List<Constellation> ByAll(int id){
		List<Constellation> list=new ArrayList<Constellation>();
		Connection conn=Bacedao.getConn();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from constellation where id="+id;
		try {
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Constellation conl=new Constellation();
				conl.setId(rs.getInt("id"));
				conl.setName(rs.getString("name"));
				conl.setContent(rs.getString("content"));
				list.add(conl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Bacedao.closeConn(rs, pstmt, conn);
		}
		return list;
	} 
}
