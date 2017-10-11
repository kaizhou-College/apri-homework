package com.kz.entity;

public class Student {
	private String name;
	//匿名块
	//静态块
	static{
		System.out.println("我是静态块");
	}
	//对象块、普通块
	{
		System.out.println("我是对象块");
	}
	public Student(){
		System.out.println("student对象出生了");
	}
	//有名块
	public void sayHello(){
		System.out.println("say Hello");
	}
}
