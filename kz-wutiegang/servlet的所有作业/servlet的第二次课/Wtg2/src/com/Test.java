package com;

import com.Dao.BookDao;
import com.Dao.impl.BookDaoImpl;
import com.entity.Book;

public class Test {
	public static void main(String[] args) {
		BookDao bookdao=new BookDaoImpl();
		/*bookdao.getAllById(-1);
		Book book=new Book("С����1", 40, "����1");
		bookdao.insert(book);
		bookdao.delete(7);
		Book book=new Book(4,"С����2", 40, "����1");
		bookdao.update(book);*/
	}
}
