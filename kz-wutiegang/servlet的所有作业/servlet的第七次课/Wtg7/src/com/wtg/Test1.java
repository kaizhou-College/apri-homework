package com.wtg;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;


public class Test1 {
	public static void main(String[] args) {
		//进行添加菜单和菜
		try {
			//准备一张纸
			Properties ps=new Properties();
			//对这张纸进行包装
			ps.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
			Context context=new InitialContext(ps);
			//给菜单绑定对应的菜
			context.bind("一号菜","长沙臭豆腐");
			context.bind("二号菜", "花生米");
			context.bind("三号菜", "重庆火锅");
			NamingEnumeration<NameClassPair> list = context.list("");
			while(list.hasMoreElements()){
				NameClassPair nextElement = list.nextElement();
				System.out.println("nextElement==="+nextElement);
				
			}
			//根据菜单上的菜名点菜
			String c1 = (String) context.lookup("一号菜");
			String c2 = (String) context.lookup("二号菜");
			System.out.println(c1+"\t"+c2);
			//根据菜名移除菜
			context.unbind("一号菜");
			String c3 = (String) context.lookup("一号菜");
			System.out.println("c3===="+c3);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
