package com;

import com.Dao.BookDao;
import com.Dao.impl.BookDaoImpl;
import com.entity.Book;

public class Test {
	public static void main(String[] args) {
		BookDao bookdao=new BookDaoImpl();
		/*bookdao.getAllById(-1);
		Book book=new Book("小王子1", 40, "老王1");
		bookdao.insert(book);
		bookdao.delete(7);
		Book book=new Book(4,"小王子2", 40, "老王1");
		bookdao.update(book);*/
	}
}
