package com.kz.servlet;

public class A {
	public static void main(String[] args) {
		StringBuffer s = new StringBuffer("�մ�����ɵ��");//�մ�����**
		if(s.indexOf("ɵ��")>0){
			int start = s.toString().indexOf("ɵ��");
			//����key="ɵ��" ��ȡֵ=**
			String s2 = (s.substring(0,start)).concat("**");
			System.out.println(s2);
		}
	}
}
