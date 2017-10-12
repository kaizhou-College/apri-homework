package com.kz.test;

import com.kz.entity.Student;

public class Test2 {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		//方式三：对象.getClass();
		Student s = new Student();
		Class clazz = s.getClass();
		Student s2 =(Student) clazz.newInstance();
		s2.sayHello();
		//方式四：类加载器
		//得到系统类加载器-----类加载的机制？
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		Class clazz2 = cl.loadClass("com.kz.entity.Student");
		Student s3 = (Student) clazz2.newInstance();
		s3.sayHello();
	}
}
