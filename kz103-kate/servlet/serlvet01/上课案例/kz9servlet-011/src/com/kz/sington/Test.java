package com.kz.sington;

public class Test {
	public static void main(String[] args) {
		Student s1 = Student.getStudent();
		//hashcode�Ƕ������ڴ��е�ַ��������ʽ
		System.out.println(s1.hashCode());
		Student s2 = Student.getStudent();
		System.out.println(s2.hashCode());
		Student s3 = Student.getStudent();
		System.out.println(s3.hashCode());
		Student s4 = Student.getStudent();
		System.out.println(s4.hashCode());
	}
}
