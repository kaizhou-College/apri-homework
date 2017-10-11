package com.kz.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class work06 {
	public static void main(String[] args) throws MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		URL url = new URL("http://localhost:8080/test/test.jar");
		URL[] urls = new URL[]{url};
		URLClassLoader loader = new URLClassLoader(urls);
		Class cla = loader.loadClass("com.kz.test.Students");
		Students stu = (Students) cla.newInstance();
		System.out.println(stu);
	}
}
