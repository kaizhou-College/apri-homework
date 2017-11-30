package com.kz.test;

public class Student {
	//String name;
	public int getName(){
		String name ="abc";
		System.out.println("abc");
		System.out.println(name);
		return 100;
	}
	public static void main(String[] args) {
		//System.out.println(name);
		Student s = new Student();
		//java对象能点出来的必须在类型先定义好
		//System.out.println(s.name);
		//对象有哪些属性和方法都由这个类决定
		//System.out.println(s.age);
		System.out.println(s.getName());
	}
}
