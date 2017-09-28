package com.kz.test;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

import org.apache.naming.java.javaURLContextFactory;
/*
 * Tomcat也有jndi的功能：
 * 	允许程序员制作jndi目录？
 * 		key-----值：根据键找到值
 * 
 * 		java/bean------拿到Man类的对象?
 * 
 */
public class Test1 {
	public static void main(String[] args) throws NamingException {
		//1,准备一张白纸
		Properties ps = new Properties();
		//2,对其进行包装----包装成菜单样子(导入name包)
		ps.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		//3,进行添加菜单名和菜
		Context context = new InitialContext(ps);
		context.bind("一号菜","腊肉炒香肠");
		context.bind("二号菜",new Dog("二狗子",2));
		context.bind("三号菜","蚂蚁上树");
		//4,测试根据菜单名得到菜
		/*NamingEnumeration list = context.list("");
		while (list.hasMoreElements()) {
			//key--值类型
			Object obj = list.nextElement();
			System.out.println(obj);
		}*/
		String c1 = (String) context.lookup("一号菜");
		System.out.println(c1);
		Dog dog  = (Dog) context.lookup("二号菜");
		System.out.println(dog);
		//移除
		context.unbind("一号菜");
		NamingEnumeration list = context.list("");
		while (list.hasMoreElements()) {
			//key--值类型
			Object obj = list.nextElement();
			System.out.println(obj);
		}
	}
}
