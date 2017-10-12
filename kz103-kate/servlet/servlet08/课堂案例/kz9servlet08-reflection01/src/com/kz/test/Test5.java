package com.kz.test;

import java.net.URL;
import java.net.URLClassLoader;


//ÍøÂç¼ÓÔØÆ÷
public class Test5 {
	public static void main(String[] args) throws Exception{
		URL url = new URL("http://localhost:8080/kz9servlet08-net/man.jar");
		URL[] urls = new URL[]{url};
		URLClassLoader loader = new URLClassLoader(urls);
		Class clazz = loader.loadClass("com.kz.entity.Man");
		System.out.println(clazz.toString());
		//Man man = (Man) clazz.newInstance();
		//System.out.println(man);
	}
}
