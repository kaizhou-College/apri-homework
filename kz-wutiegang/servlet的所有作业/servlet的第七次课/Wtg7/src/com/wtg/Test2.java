package com.wtg;

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
			//׼��һ�Ű�ֽ
			Properties ps=new Properties();
			//��ֽ��װ�����
			ps.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.FSContextFactory");
			Context context = new InitialContext(ps);
			//��ȡ��ǰ��ĸ�Ŀ¼�µ��ļ����ļ���
			NamingEnumeration<NameClassPair> list = context.list("");
			while (list.hasMoreElements()) {
				NameClassPair nextElement = list.nextElement();
				System.out.println("nextElement=="+nextElement);
				
			}
			File file =(File) context.lookup("a.txt");
			//���ļ�
			FileReader fr=new FileReader(file);
			char[] ch=new char[1024];
			int read = fr.read(ch);
			while(read!=-1){
				System.out.println(new String(ch));
				read = fr.read(ch);
			}
			fr.close();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
