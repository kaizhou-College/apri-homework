package com.wtg;


import com.wtg.entity.Student;

public class Test1 {
	public static void main(String[] args) {
		//��һ�ַ�ʽ�õ���Class��:��ʱ����
		try {
			Class c1 = Class.forName("com.wtg.entity.Student");
			//��������
			Student s = (Student) c1.newInstance();
			System.out.println(s.toString());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//�ڶ��ַ����õ�Calss�ࣺ��ʱ����
		
		try {
			Class c2=Student.class;
			Student s2=(Student) c2.newInstance();
			System.out.println(s2.toString());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�����ַ����õ�Class�ࣺ����.getclass()
		Student s3=new Student();
		
		try {
			Class c3=s3.getClass();
			Student s4=(Student) c3.newInstance();
			System.out.println(s4.toString());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//�����ַ����õ�Class�ࣺ�������
	
		try {
			ClassLoader cl =ClassLoader.getSystemClassLoader();
			Class c5=cl.loadClass("com.wtg.entity.Student");
			Student s6=(Student) c5.newInstance();
			System.out.println(s6.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
