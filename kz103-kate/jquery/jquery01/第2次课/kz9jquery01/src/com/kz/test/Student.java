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
		//java�����ܵ�����ı����������ȶ����
		//System.out.println(s.name);
		//��������Щ���Ժͷ���������������
		//System.out.println(s.age);
		System.out.println(s.getName());
	}
}
