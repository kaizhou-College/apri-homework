package com.wtg.entity;

public class A {
	private String name;

	@Override
	public String toString() {
		return "A [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	static{
		System.out.println("���뾲̬��");
	}
	{
		System.out.println("��������");
	}
}
