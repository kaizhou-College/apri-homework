package com.wtg.entity;

import java.io.Serializable;
/**
 * //静态属性和瞬时属性不会被序列化
	private static int a;
	private transient int b;
	
 * @author WTG
 *
 */
public class Child implements Serializable{
	private int age;
	private String name;
	private static int a;
	private transient int b;
	public static int getA() {
		return a;
	}
	public static void setA(int a) {
		Child.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Child [age=" + age + ", b=" + b + ", name=" + name + "]";
	}
	
}
