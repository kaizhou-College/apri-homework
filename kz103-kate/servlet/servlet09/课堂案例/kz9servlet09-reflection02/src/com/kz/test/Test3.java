package com.kz.test;

import java.lang.reflect.Constructor;

import javax.crypto.ExemptionMechanismException;

import com.kz.entity.Student;

import sun.security.pkcs11.wrapper.Constants;
/**
 * 通过Class类获取类中的属性：
 * getConstructor()-------------获取指定公有构造方法
 * getConstructors()------------获取所有公有构造方法
 * getDeclaredConstructor()-----获取指定非公有构造方法
 * getDeclaredConstructors()----获取所有非公有构造方法
 * getName()-------------获取构造方法名字
 * @author mr.chan
 *
 */

public class Test3 {
	public static void main(String[] args) throws Exception{
		Class clazz = Class.forName("com.kz.entity.Student");
		//得到对象---调用无参数的构造构造方法
		//Student s = (Student) clazz.newInstance();
		//1.得到1个参数的构造方法
		 Constructor constructor = clazz.getConstructor(String.class);
		 Student s2 = (Student) constructor.newInstance("二狗子");
		 System.out.println(s2.toString());
		 //2,获取所有非公有构造方法
		 Constructor[] constructors = clazz.getDeclaredConstructors();
		 for(int i=0;i<constructors.length;i++){
			 System.out.println(constructors[i].getName()+"\t"+constructors[i].getModifiers());
		 }
	}
}
