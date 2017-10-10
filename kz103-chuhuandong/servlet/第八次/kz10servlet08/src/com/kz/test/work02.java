package com.kz.test;

public class work02 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//¼´•r¼ÓÝd
//		Class cls = Class.forName("com.kz.test.Students");
//		Students stu = (Students) cls.newInstance();
//		stu.hei();
		//ÑÓ•r¼ÓÝd
		Class cls = Students.class;
		Students stu = (Students) cls.newInstance();
		stu.hei();
	}
}
