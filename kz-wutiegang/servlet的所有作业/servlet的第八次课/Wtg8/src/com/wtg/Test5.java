package com.wtg;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Test5 {
	public static void main(String[] args) throws Exception {
		URL url=new URL("http://localhost:8080/test/Test.jar");
		URL[] urls=new URL[]{url};
		URLClassLoader loader=new URLClassLoader(urls);
		Class clazz = loader.loadClass("com.wtg.entity.Test");
		System.out.println(clazz.toString());
	}
}
