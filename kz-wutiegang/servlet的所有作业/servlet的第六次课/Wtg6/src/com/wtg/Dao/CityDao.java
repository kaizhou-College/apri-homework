package com.wtg.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wtg.entity.City;

public class CityDao extends BaseDao{
	public ArrayList<City> findCity(int id){
		ArrayList<City> list=new ArrayList<City>();
		
		try {
			getconnection();
			String sql="select * from city where pid="+id;
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				int pid=rs.getInt("pid");
				City city=new City();
				city.setCid(cid);
				city.setCname(cname);
				city.setPid(pid);
				list.add(city);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnection();
		}
		return list;
	}
	public static void main(String[] args) {
		for (City c : new CityDao().findCity(19)) {
			System.out.println(c);
		}
	}
}
