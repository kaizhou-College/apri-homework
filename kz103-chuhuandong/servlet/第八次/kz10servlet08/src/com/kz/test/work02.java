package com.kz.test;

public class work02 {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//���r���d
//		Class cls = Class.forName("com.kz.test.Students");
//		Students stu = (Students) cls.newInstance();
//		stu.hei();
		//�ӕr���d
		Class cls = Students.class;
		Students stu = (Students) cls.newInstance();
		stu.hei();
	}
}
