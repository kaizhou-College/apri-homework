package com.wtg;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.wtg.entity.A;

public class Test2 {
	
	public static void main(String[] args) throws Exception {
		Class c1 = Class.forName("com.wtg.entity.A");
		A a = (A) c1.newInstance();
		Field fa = c1.getField("a");
		fa.set(a, 6);
		Field fb = c1.getDeclaredField("b");
		fb.setAccessible(true);
		fb.set(a, 10);
		Method m=c1.getDeclaredMethod("showA", null);
		System.out.println(m.invoke(a, null));
		Method m1=c1.getDeclaredMethod("showB", null);
		m1.setAccessible(true);
		System.out.println(m1.invoke(a, null));
	}
}
