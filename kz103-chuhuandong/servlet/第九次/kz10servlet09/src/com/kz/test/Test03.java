package com.kz.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import com.kz.entity.B;

public class Test03 {
	public static void main(String[] args) throws Exception {
		Class cls = Class.forName("com.kz.entity.B");
		B b = (B)cls.newInstance();
		Constructor constructor = cls.getDeclaredConstructor(int.class);
		Constructor constructor2 = cls.getDeclaredConstructor(Integer.class);
		B b1 = (B) constructor.newInstance(1);
		B b2 = (B)constructor2.newInstance(5);
	}
}
