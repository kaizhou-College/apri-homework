package com.kz.test;

import com.kz.entity.Student;

//B
public class Test1 {
	//a.txt -----File��Ķ���read()  write
	//File f = new File("a.txt");
	//.java------>.class�ļ�(�������ʶ��Ķ����Ʊ���)----java������֮��Ӧ��Class����
	//���һ��ϵͳ��������(���˿���-----)
	//A:	Student��   		:com.kz.entity	
	//B: 	ʹ��student��
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//�õ�Class�����ķ�ʽһ����ʱ����
		// ��̬����
		//Student stu = new Student();
		//���䣺��̬����
		//clazz����������Student.java����������Student.class�ļ�
		Class clazz = Class.forName("com.kz.entity.Student");
		//��������
		Student s = (Student) clazz.newInstance();
		s.sayHello();
		System.out.println("---------------");
		//����������ʱ����
		Class clazz2 = Student.class;
		Student s2 = (Student) clazz2.newInstance();
		s2.sayHello();
		
		
	}
}
