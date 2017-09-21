package com.Dao;

import java.util.ArrayList;

import com.entity.Book;

public interface BookDao {
	//查询全部
	public ArrayList<Book> getAllById(int Id);
	//新增
	public int insert(Book book);
	//删除
	public int delete(int Id);
	//修改
	public int update(Book book);
	
}
