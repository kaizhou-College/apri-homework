package test;

import java.lang.reflect.Constructor;

import entity.B;

public class work3 {
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("entity.B");
		//第一
		B b = (B) clazz.newInstance();
		//第二
		Constructor constructor = clazz.getDeclaredConstructor(int.class);
		B b1 = (B) constructor.newInstance(1);
		//第三
		Constructor constructor2 = clazz.getDeclaredConstructor(Integer.class);
		B b2 = (B) constructor2.newInstance(15);
	}
}
