package com.kz.test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.kz.entity.Student;

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
public class Test1 {
	public static void main(String[] args) throws Exception {
	
		Class clazz = Class.forName("com.kz.entity.Student");
		//得到对象
		Student s = (Student) clazz.newInstance();
		//1,得到公有属性:属性有一个类与之对应
		Field fsex =clazz.getField("sex");
		//2,给属性赋值  
		fsex.set(s, "女");//s.setSex("女");
		//3,获取属性值		s.getSex();
		System.out.println(fsex.get(s));
		//1.2得到所有属性
		Field[] fields = clazz.getDeclaredFields();
		for(int i=0;i<fields.length;i++){
			System.out.println(soEasy(fields[i].getModifiers())+
					"\t"+getTypes(fields[i].getType())
					+"\t"+fields[i].getName());
		}
		/*Field fname = clazz.getDeclaredField("name");
		//暴力破解封装
		fname.setAccessible(true);
		
		fname.set(s, "二狗子"); //s.setName("二狗子");
		System.out.println(fname.get(s));*/
		
		
	}
	public static String soEasy(int modify){
		/*if(modify==0){
			return "";
		}else if(modify==1){
			return "public" ;
		}else if(modify==2){
			return "private";
		}else{
			return "protected";
		}*/
		return Modifier.toString(modify);
	}
	public static String getTypes(Class Type){
		StringBuffer sb = new StringBuffer();
		String type = Type.getSimpleName();
		sb.append(type);
		//System.out.println(String.class.getSimpleName());
		//System.out.println(String.class.getName());
		return sb.toString();
	}
}
