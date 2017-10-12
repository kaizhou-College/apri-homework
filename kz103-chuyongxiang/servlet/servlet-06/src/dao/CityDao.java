package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.City;


public class CityDao {

	public List<City> findByPid(int pid){
		 List<City>  list = new ArrayList<City>();
		 Connection conn = BaseDao.getConn();
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 
		 String sql = " select * from city where pid="+pid;
		 try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				City city = new City();
				city.setCid(rs.getInt("cid"));
				city.setName(rs.getString("name"));
				city.setPid(rs.getInt("pid"));
				
				list.add(city);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(rs, pstmt, conn);
		}
		 return list;
	}
	public static void main(String[] args) {
		for(City c :new CityDao().findByPid(5)){
			System.out.println(c);
		}
	}
}
