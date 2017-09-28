package com.kz.test;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

import org.apache.naming.java.javaURLContextFactory;
/*
 * TomcatҲ��jndi�Ĺ��ܣ�
 * 	�������Ա����jndiĿ¼��
 * 		key-----ֵ�����ݼ��ҵ�ֵ
 * 
 * 		java/bean------�õ�Man��Ķ���?
 * 
 */
public class Test1 {
	public static void main(String[] args) throws NamingException {
		//1,׼��һ�Ű�ֽ
		Properties ps = new Properties();
		//2,������а�װ----��װ�ɲ˵�����(����name��)
		ps.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		//3,������Ӳ˵����Ͳ�
		Context context = new InitialContext(ps);
		context.bind("һ�Ų�","���⳴�㳦");
		context.bind("���Ų�",new Dog("������",2));
		context.bind("���Ų�","��������");
		//4,���Ը��ݲ˵����õ���
		/*NamingEnumeration list = context.list("");
		while (list.hasMoreElements()) {
			//key--ֵ����
			Object obj = list.nextElement();
			System.out.println(obj);
		}*/
		String c1 = (String) context.lookup("һ�Ų�");
		System.out.println(c1);
		Dog dog  = (Dog) context.lookup("���Ų�");
		System.out.println(dog);
		//�Ƴ�
		context.unbind("һ�Ų�");
		NamingEnumeration list = context.list("");
		while (list.hasMoreElements()) {
			//key--ֵ����
			Object obj = list.nextElement();
			System.out.println(obj);
		}
	}
}
