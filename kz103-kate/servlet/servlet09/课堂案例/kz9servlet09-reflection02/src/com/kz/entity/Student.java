package com.kz.entity;

public class Student {
	public Student(){
		System.out.println("调用无参数的构造方法");
	}
	public Student(String name){
		System.out.println("调用一个参数的构造方法");
		this.name = name;
	}
	public Student(String name,int age){
		System.out.println("调用二个参数的构造方法");
		this.name = name;
		this.age = age;
	}
	
	int age;
	private String name;
	protected int salary;
	public String sex;
	
	public String sayHello(){
		return "你好，反射";
	}
	private void 谈恋爱(int a ,String b,double c){
		System.out.println(name+"在谈恋爱");
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
