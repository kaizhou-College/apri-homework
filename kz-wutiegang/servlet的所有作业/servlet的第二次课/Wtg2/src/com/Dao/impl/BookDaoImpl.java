package com.Dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Dao.BaseDao;
import com.Dao.BookDao;
import com.entity.Book;

public class BookDaoImpl extends BaseDao implements BookDao{
//删除
	public int delete(int Id) {
		// TODO Auto-generated method stub
		int number=-1;
		try {
			getconnection();
			String sql="delete from Book where ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Id);
			number=pstmt.executeUpdate();
			if(number>0){
				System.out.println("删除成功");
			}else{
				System.out.println("删除失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeconnection();
		}
		return number;
	}
//查询
	public ArrayList<Book> getAllById(int Id) {
		// TODO Auto-generated method stub
		ArrayList<Book> list=new ArrayList<Book>();
		try {
			getconnection();
			String sql="select * from Book";
			if(Id>0){
				sql="select * from Book where Id=?";
			}
			pstmt=conn.prepareStatement(sql);
			if(Id>0){
				pstmt.setInt(1, Id);
			}
			rs = pstmt.executeQuery();
			while(rs.next()){
				int ID=rs.getInt("ID");
				String name=rs.getString("name");
				int price=rs.getInt("price");
				String writer=rs.getString("writer");
				Book book=new Book(ID,name,price,writer);
				System.out.println(book.toString());
				list.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeconnection();
		}
		
		return list;
	}
//新增
	public int insert(Book book) {
		// TODO Auto-generated method stub
		int number=-1;
		try {
			getconnection();
			String sql="insert into Book values(seq_Book.nextval,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			Object[] objs={
					book.getName(),book.getPrice(),book.getWriter()};
			for (int i = 0; i < objs.length; i++) {
				pstmt.setObject(i+1, objs[i]);
			}
			number=pstmt.executeUpdate();
			if(number>0){
				System.out.println("新增成功");
			}else{
				System.out.println("新增失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeconnection();
		}
		return number;
	}
//更新
	public int update(Book book) {
		// TODO Auto-generated method stub
		int number=-1;
		try {
			getconnection();
			String sql="update Book set name=?,price=? where ID=?";
			pstmt=conn.prepareStatement(sql);
			Object objs[]={book.getName(),book.getPrice(),book.getId()};
			for (int i = 0; i < objs.length; i++) {
				pstmt.setObject(i+1, objs[i]);
			}
			number=pstmt.executeUpdate();
			if(number>0){
				System.out.println("更新成功");
			}else{
				System.out.println("更新失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeconnection();
		}
		return number;
	}

}
