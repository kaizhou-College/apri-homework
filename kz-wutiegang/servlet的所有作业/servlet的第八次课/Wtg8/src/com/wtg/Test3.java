package com.wtg;

public class Test3 {
	public static void main(String[] args) {
		//�õ�ϵͳ������
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		//�õ���չ������
		ClassLoader c2 = cl.getParent();
		//�õ���������
		ClassLoader c3 = c2.getParent();
		System.out.println("���еĸ��������"+cl+"======="+c2+"======="+c3);
	}
}
