package com.kz.servlet;

public class A {
	public static void main(String[] args) {
		StringBuffer s = new StringBuffer("苏大妈是傻逼");//苏大妈是**
		if(s.indexOf("傻逼")>0){
			int start = s.toString().indexOf("傻逼");
			//根据key="傻逼" 获取值=**
			String s2 = (s.substring(0,start)).concat("**");
			System.out.println(s2);
		}
	}
}
