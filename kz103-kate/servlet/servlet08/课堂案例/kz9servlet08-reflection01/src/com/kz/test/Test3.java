package com.kz.test;

public class Test3 {
	//����صķ���
	public static void main(String[] args) {
		//1,�õ�ϵͳ������
		//sun.misc.Launcher$AppClassLoader@1372a1a
		ClassLoader c1= ClassLoader.getSystemClassLoader();
		System.out.println(c1);
		//2,��չ������sun.misc.Launcher$ExtClassLoader@ad3ba4
		ClassLoader c2 = c1.getParent();
		System.out.println(c2);
		//3,��������  ������������ʹ��java��������д�ģ�ʹ��C++����
		//����д��  sun��˾��û�й�������������Դ��
		ClassLoader c3 = c2.getParent();
		System.out.println(c3);
	}
}
