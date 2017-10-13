package com.wtg;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.wtg.entity.A;

/**
 * 
 * @author WTG
 * 通过Class类获取类中的属性：
 * getField()-------------获取指定公有属性
 * getFields()------------获取所有公有属性
 * getDeclaredField()-----获取指定非公有属性
 * getDeclaredFields()----获取所有非公有属性
 * getName()-------------获取属性名字
 */
public class Test1 {
	public static void main(String[] args) throws Exception {
		//找到在哪个包下面的A类
		Class c1 = Class.forName("com.wtg.entity.A");
		//得到对象
		A a = (A) c1.newInstance();
		//1.得到公有属性：属性有一个类与之对应
		Field fa = c1.getField("a");
		//2.给属性赋值
		fa.set(a, 1);
		//3.获取属性值
		System.out.println(fa.get(a));
		Field fa1 = c1.getDeclaredField("b");
		fa1.setAccessible(true);
		fa1.set(a, 2);
		
		System.out.println(fa1.get(a));
		//得到所有属性
		Field[] fields = c1.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println(RPm(fields[i].getModifiers())+"\t"+
					fields[i].getType()+"\t"+fields[i].getName());
		}
		Method showA=c1.getMethod("showA", new Class[]{int.class});
		//调用方法
		System.out.println(showA.invoke(a, new Integer[]{3}));
		Method showB=c1.getDeclaredMethod("showB", null);
		showB.setAccessible(true);
		System.out.println(showB.invoke(a, null));
		//得到所有方法
		Method[] methods = c1.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.println(RPm(methods[i].getModifiers())+"\t"
					+methods[i].getReturnType()+"\t"
					+methods[i].getName()+"();"
					
			);
			
		}
	}
	public static String RPm(int m){
		return Modifier.toString(m);
	}
	
}
