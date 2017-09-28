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
		//����windowĿ¼�����	
		ps.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.FSContextFactory");
		Context context = new InitialContext(ps);
		//��ȡ��ǰ��ĸ�Ŀ¼�µ��ļ��Լ��ļ���
		//NamingEnumeration ne = context.list("D:\\image");	
		NamingEnumeration ne = context.list("");	
		while(ne.hasMore()){
		    Object o = ne.next();
		    System.out.println(o);
		}
		
		File file = (File) context.lookup("a.html");
		//���ļ�
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
