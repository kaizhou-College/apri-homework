package com.wtg.Test;

import com.wtg.Dao.BaseDao;
import com.wtg.entity.Book;
import com.wtg.entity.StudentInfo;

public class Test6$ {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		BaseDao b=new BaseDao();
		Book book=new Book();
		book.setId(8);
		book.setName("ธีธี1");
		book.setWriter("ะกะก");
		book.setPrice(30);
		b.update(book);
	}
}
