package com.wtg.Test;

import com.wtg.Dao.BaseDao;
import com.wtg.entity.Book;
import com.wtg.entity.StudentInfo;

public class Test1 {
	public static void main(String[] args) {
		BaseDao b=new BaseDao();
		Book book=new Book();
		book.setName("����");
		
		book.setPrice(30);
		book.setWriter("С��");
		System.out.println(b.save("seq_book", book));
	}
}
