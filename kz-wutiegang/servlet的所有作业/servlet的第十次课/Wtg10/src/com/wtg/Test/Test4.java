package com.wtg.Test;

import com.wtg.entity.Book;
import com.wtg.entity.StudentInfo;


public class Test4 {
	public static void main(String[] args) throws CloneNotSupportedException {
		//浅度克隆
		Book book=new Book();
		book.setName("十万个为什么？");
		StudentInfo stu=new StudentInfo();
		stu.setStuname("老王");
		book.setStu(stu);
		System.out.println(book.getStu().getStuname());
		//深度克隆
		Book book1=(Book) book.clone();
		book1.setName("萧大妈");
		//改邓大妈的女朋友的名字
		book1.getStu().setStuname("建军节");
		System.out.println(book.getStu().getStuname());
		System.out.println(book1.getStu().getStuname());
	}
}
