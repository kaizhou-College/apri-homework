package com.wtg.Test;

import com.wtg.entity.Book;
import com.wtg.entity.StudentInfo;


public class Test4 {
	public static void main(String[] args) throws CloneNotSupportedException {
		//ǳ�ȿ�¡
		Book book=new Book();
		book.setName("ʮ���Ϊʲô��");
		StudentInfo stu=new StudentInfo();
		stu.setStuname("����");
		book.setStu(stu);
		System.out.println(book.getStu().getStuname());
		//��ȿ�¡
		Book book1=(Book) book.clone();
		book1.setName("������");
		//�ĵ˴����Ů���ѵ�����
		book1.getStu().setStuname("������");
		System.out.println(book.getStu().getStuname());
		System.out.println(book1.getStu().getStuname());
	}
}
