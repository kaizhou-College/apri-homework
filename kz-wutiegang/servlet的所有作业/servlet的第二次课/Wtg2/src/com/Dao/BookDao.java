package com.Dao;

import java.util.ArrayList;

import com.entity.Book;

public interface BookDao {
	//��ѯȫ��
	public ArrayList<Book> getAllById(int Id);
	//����
	public int insert(Book book);
	//ɾ��
	public int delete(int Id);
	//�޸�
	public int update(Book book);
	
}
