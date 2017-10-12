package com.kz.test;

import com.kz.entity.Student;

//B
public class Test1 {
	//a.txt -----File类的对象：read()  write
	//File f = new File("a.txt");
	//.java------>.class文件(计算机可识别的二进制编码)----java类型与之对应：Class类型
	//设计一个系统：飞行器(多人开发-----)
	//A:	Student类   		:com.kz.entity	
	//B: 	使用student类
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//得到Class类对象的方式一：及时加载
		// 静态编译
		//Student stu = new Student();
		//反射：动态编译
		//clazz对象代表的是Student.java这个类编译后的Student.class文件
		Class clazz = Class.forName("com.kz.entity.Student");
		//创建对象
		Student s = (Student) clazz.newInstance();
		s.sayHello();
		System.out.println("---------------");
		//方法二：延时加载
		Class clazz2 = Student.class;
		Student s2 = (Student) clazz2.newInstance();
		s2.sayHello();
		
		
	}
}
