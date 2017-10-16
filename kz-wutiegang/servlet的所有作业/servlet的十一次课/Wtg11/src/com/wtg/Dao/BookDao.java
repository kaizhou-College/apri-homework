package com.wtg.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wtg.entity.Book;


public class BookDao {
	//查询
	public static ArrayList<Book> getAll(){
		ArrayList<Book> list=new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		try {
			conn=BaseDao.getconn();
			String sql="select * from book";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String writer = rs.getString("writer");
				Book book=new Book(id,name,price,writer);
				System.out.println(book.toString());
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static List<Book> selByPage(int pagesize,int page){
		List<Book> list = new ArrayList<Book>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int min = (page-1)*pagesize;
		int max = page*pagesize;
		
		try {
			conn = BaseDao.getconn();
			String sql  ="select * from" +
					"(select rownum num,t.* from Book t)" +
					" where num>"+min+" and num<="+max;
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getInt("price"));
				book.setWriter(rs.getString("writer"));
				//把对象放入集合
				list.add(book);
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			BaseDao.closeConn(rs, pst, conn);
		}
		
		return list;
	}
	//得到总页数的方法  总页数=总条数/每页的条数
	public static int getMaxPage(int pagesize){
		ArrayList<Book> all = getAll();
		int num=all.size();
		int maxPage=num/pagesize;
		if (num%pagesize!=0) {
			maxPage+=1;
		}
		return maxPage;
		
	}
	/*public static void main(String[] args) {
		BookDao bookdao=new BookDao();
		System.out.println(bookdao.getMaxPage(2));
	}*/
}
