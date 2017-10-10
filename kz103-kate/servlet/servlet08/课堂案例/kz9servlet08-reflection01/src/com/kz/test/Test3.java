package com.kz.test;

public class Test3 {
	//类加载的分类
	public static void main(String[] args) {
		//1,得到系统加载器
		//sun.misc.Launcher$AppClassLoader@1372a1a
		ClassLoader c1= ClassLoader.getSystemClassLoader();
		System.out.println(c1);
		//2,扩展加载器sun.misc.Launcher$ExtClassLoader@ad3ba4
		ClassLoader c2 = c1.getParent();
		System.out.println(c2);
		//3,根加载器  根加载器不是使用java语言来编写的，使用C++语言
		//来编写的  sun公司并没有公布根加载器的源码
		ClassLoader c3 = c2.getParent();
		System.out.println(c3);
	}
}
