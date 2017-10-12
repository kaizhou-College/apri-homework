package com.wtg;

public class Test3 {
	public static void main(String[] args) {
		//得到系统加载器
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		//得到扩展加载器
		ClassLoader c2 = cl.getParent();
		//得到跟加载器
		ClassLoader c3 = c2.getParent();
		System.out.println("所有的父类加载器"+cl+"======="+c2+"======="+c3);
	}
}
