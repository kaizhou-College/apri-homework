package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.book;

public class bookBao {
	public static List sel(String user,String password){
		Connection conn = BaseDao.getconn(user, password);
		PreparedStatement st=null;
		ResultSet rs=null;
		List<book> list=new ArrayList();
		try {
			st = conn.prepareCall("select * from book  ");
			rs=st.executeQuery();
			while(rs.next()){
				book u=new book();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPrice(rs.getInt("price"));
				u.setWriter(rs.getString("price"));
				list.add(u);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static int insert(int id,String name ,int price,String writer ){
		Connection conn = BaseDao.getconn("scott", "orcl");
		PreparedStatement st=null;
		int num=0;
		try {
			st=conn.prepareStatement("insert into book values(?,?,?,?)");
			st.setInt(1,id );
			st.setString(2,name);
			st.setInt(3,price);
			st.setString(4,writer);
			num = st.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
	}
	public static void main(String[] args) {
		List sel = sel(null,null);
		for (int i = 0; i < sel.size(); i++) {
			System.out.println(sel.get(i));
		}
		//System.out.println(insert( 4,"as",12,"ffh"));
	}
}
