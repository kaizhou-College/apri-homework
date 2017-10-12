package com.wtg;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import com.wtg.entity.B;

public class Test3 {
	public static void main(String[] args) throws Exception {
		Class c1 = Class.forName("com.wtg.entity.B");
		//�õ�����---�����޲����Ĺ��췽��
		B b = (B) c1.newInstance();
		//�õ�һ�������Ĺ��췽��
		Constructor constructor = c1.getConstructor(int.class);
		B b1 = (B) constructor.newInstance(1);
		System.out.println(b1.toString());
		Constructor constructor2 = c1.getConstructor(Integer.class);
		B b2 = (B) constructor2.newInstance(1);
		System.out.println(b2.toString());
		//��ȡ���зǹ��еĹ��췽��
		Constructor[] constructors = c1.getDeclaredConstructors();
		for (int i = 0; i < constructors.length; i++) {
			System.out.println(M(constructors[i].getModifiers())+"\t"+constructors[i].getTypeParameters()+"\t"+constructors[i].getName());
		}
		
	}
	public static String M(int m){
		return Modifier.toString(m);
	}
}
