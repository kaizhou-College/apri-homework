package com.kz.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

public class Test2 {
	public static void main(String[] args) throws NamingException, IOException {
		Properties ps = new Properties();
		//导入window目录服务包	
		ps.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.FSContextFactory");
		Context context = new InitialContext(ps);
		//获取当前类的根目录下的文件以及文件夹
		//NamingEnumeration ne = context.list("D:\\image");	
		NamingEnumeration ne = context.list("");	
		while(ne.hasMore()){
		    Object o = ne.next();
		    System.out.println(o);
		}
		
		File file = (File) context.lookup("a.html");
		//读文件
		FileReader fr = new FileReader(file);
		char[] cbuf = new char[1024];
		int len = fr.read(cbuf);
		while(len!=-1){
			System.out.println(new String(cbuf));
			len = fr.read(cbuf);
		}
		fr.close();
		
		
	}
}
