package com.kz.test;

import java.lang.reflect.Field;

import com.kz.entity.A;

public class Test02 {
	public static void main(String[] args) throws Exception {
		Class cls = Class.forName("com.kz.entity.A");
		A a=(A)cls.newInstance();
		Field field = cls.getField("a");
		Field field2 = cls.getDeclaredField("b");
		field2.setAccessible(true);
		field.setInt(a, 6);
		field2.setInt(a, 10);
		System.out.println(field.get(a)+""+field2.get(a));
	}
}
