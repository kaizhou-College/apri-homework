package com.kz.entity;

public class Student {
	private String name;
	//������
	//��̬��
	static{
		System.out.println("���Ǿ�̬��");
	}
	//����顢��ͨ��
	{
		System.out.println("���Ƕ����");
	}
	public Student(){
		System.out.println("student���������");
	}
	//������
	public void sayHello(){
		System.out.println("say Hello");
	}
}
