package com.wtg;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import com.wtg.entity.B;

public class Test3 {
	public static void main(String[] args) throws Exception {
		Class c1 = Class.forName("com.wtg.entity.B");
		//得到对象---调用无参数的构造方法
		B b = (B) c1.newInstance();
		//得到一个参数的构造方法
		Constructor constructor = c1.getConstructor(int.class);
		B b1 = (B) constructor.newInstance(1);
		System.out.println(b1.toString());
		Constructor constructor2 = c1.getConstructor(Integer.class);
		B b2 = (B) constructor2.newInstance(1);
		System.out.println(b2.toString());
		//获取所有非公有的构造方法
		Constructor[] constructors = c1.getDeclaredConstructors();
		for (int i = 0; i < constructors.length; i++) {
			System.out.println(M(constructors[i].getModifiers())+"\t"+constructors[i].getTypeParameters()+"\t"+constructors[i].getName());
		}
		
	}
	public static String M(int m){
		return Modifier.toString(m);
	}
}
