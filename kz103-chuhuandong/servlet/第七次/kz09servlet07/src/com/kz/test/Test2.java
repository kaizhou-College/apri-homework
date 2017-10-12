package com.kz.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

public class Test2 {
	public static void main(String[] args) {
		
		try {
			Properties ps=new Properties();
			ps.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.FSContextFactory");
			Context context = new InitialContext(ps);
			NamingEnumeration<NameClassPair> list = context.list("");
			while (list.hasMoreElements()) {
				NameClassPair nextElement = list.nextElement();
				System.out.println("nextElement=="+nextElement);
			}
			File file =(File) context.lookup("a.txt");
			FileReader fr=new FileReader(file);
			char[] ch=new char[1024];
			int read = fr.read(ch);
			while(read!=-1){
				System.out.println(new String(ch));
				read = fr.read(ch);
			}
			fr.close();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
