package com.wtg.Dao;


import java.sql.SQLException;
import java.util.ArrayList;

import com.wtg.entity.Province;

public class ProvinceDao extends BaseDao {
	//²éÑ¯È«²¿
	public ArrayList<Province> getAllProvince(){
		ArrayList<Province> list=new ArrayList<Province>();
		
		try {
			getconnection();
			String sql="select * from province";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				Province pr=new Province();
				pr.setPid(pid);
				pr.setPname(pname);
				list.add(pr);
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
		for (Province p : new ProvinceDao().getAllProvince()) {
			System.out.println(p);
		}
	}
}
