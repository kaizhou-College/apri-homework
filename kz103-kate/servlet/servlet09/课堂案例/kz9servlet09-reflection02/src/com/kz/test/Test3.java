package com.kz.test;

import java.lang.reflect.Constructor;

import javax.crypto.ExemptionMechanismException;

import com.kz.entity.Student;

import sun.security.pkcs11.wrapper.Constants;
/**
 * ͨ��Class���ȡ���е����ԣ�
 * getConstructor()-------------��ȡָ�����й��췽��
 * getConstructors()------------��ȡ���й��й��췽��
 * getDeclaredConstructor()-----��ȡָ���ǹ��й��췽��
 * getDeclaredConstructors()----��ȡ���зǹ��й��췽��
 * getName()-------------��ȡ���췽������
 * @author mr.chan
 *
 */

public class Test3 {
	public static void main(String[] args) throws Exception{
		Class clazz = Class.forName("com.kz.entity.Student");
		//�õ�����---�����޲����Ĺ��칹�췽��
		//Student s = (Student) clazz.newInstance();
		//1.�õ�1�������Ĺ��췽��
		 Constructor constructor = clazz.getConstructor(String.class);
		 Student s2 = (Student) constructor.newInstance("������");
		 System.out.println(s2.toString());
		 //2,��ȡ���зǹ��й��췽��
		 Constructor[] constructors = clazz.getDeclaredConstructors();
		 for(int i=0;i<constructors.length;i++){
			 System.out.println(constructors[i].getName()+"\t"+constructors[i].getModifiers());
		 }
	}
}
