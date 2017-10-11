package com.kz.test;

import java.lang.reflect.Field;

import com.kz.entity.A;

/**
 * 	//Student s1  =new Student();
	//s1.setName("二狗子");
	//System.out.println(s1.getName());
 * 通过Class类获取类中的属性：
 * getField()-------------获取指定公有属性
 * getFields()------------获取所有公有属性
 * getDeclaredField()-----获取指定非公有属性
 * getDeclaredFields()----获取所有非公有属性
 * getName()-------------获取属性名字
 */
public class Test01 {
	public static String soEasy(int modify){
		if(modify==0){
			return "";
		}else if(modify==1){
			return "public" ;
		}else if(modify==2){
			return "private";
		}else{
			return "protected";
		}
//		return Modifier.toString(modify);
	}
	public static void main(String[] args) throws Exception {
		Class cls = Class.forName("com.kz.entity.A");
		A a = (A)cls.newInstance();
		Field[] as = cls.getDeclaredFields();
		for (int i = 0; i < as.length; i++) {
			System.out.println(as[i].getName()+"\t"+soEasy(as[i].getModifiers())+"\t"+as[i].getType());
		}
	}
}
