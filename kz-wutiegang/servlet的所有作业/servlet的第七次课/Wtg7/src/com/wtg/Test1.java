package com.wtg;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;


public class Test1 {
	public static void main(String[] args) {
		//������Ӳ˵��Ͳ�
		try {
			//׼��һ��ֽ
			Properties ps=new Properties();
			//������ֽ���а�װ
			ps.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
			Context context=new InitialContext(ps);
			//���˵��󶨶�Ӧ�Ĳ�
			context.bind("һ�Ų�","��ɳ������");
			context.bind("���Ų�", "������");
			context.bind("���Ų�", "������");
			NamingEnumeration<NameClassPair> list = context.list("");
			while(list.hasMoreElements()){
				NameClassPair nextElement = list.nextElement();
				System.out.println("nextElement==="+nextElement);
				
			}
			//���ݲ˵��ϵĲ������
			String c1 = (String) context.lookup("һ�Ų�");
			String c2 = (String) context.lookup("���Ų�");
			System.out.println(c1+"\t"+c2);
			//���ݲ����Ƴ���
			context.unbind("һ�Ų�");
			String c3 = (String) context.lookup("һ�Ų�");
			System.out.println("c3===="+c3);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
