package com.kz.anno;
import java.util.Date;

@SuppressWarnings("asdfasd")
public class Person extends Object{
	@Override
	public String toString() {
		return super.toString();
	}
	@Deprecated
	public void fun(){
		System.out.println("���ǹ�ʱ�ķ���");
	}
	public static void main(String[] args) {
		//System.err.println(new Person().toString());
		new Person().fun();
		new Date().toLocaleString();
		//System.err.println(new Person());
	}
	
}
