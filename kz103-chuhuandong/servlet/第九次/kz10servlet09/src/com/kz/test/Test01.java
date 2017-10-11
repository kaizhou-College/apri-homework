package com.kz.test;

import java.lang.reflect.Field;

import com.kz.entity.A;

/**
 * 	//Student s1  =new Student();
	//s1.setName("������");
	//System.out.println(s1.getName());
 * ͨ��Class���ȡ���е����ԣ�
 * getField()-------------��ȡָ����������
 * getFields()------------��ȡ���й�������
 * getDeclaredField()-----��ȡָ���ǹ�������
 * getDeclaredFields()----��ȡ���зǹ�������
 * getName()-------------��ȡ��������
 */
public class Test01 {
	public static String soEasy(int modify){
		if(modify==0){
			return "";
		}else if(modify==1){
			return "public" ;
		}else if(modify==2){
			return "private";
		}else{
			return "protected";
		}
//		return Modifier.toString(modify);
	}
	public static void main(String[] args) throws Exception {
		Class cls = Class.forName("com.kz.entity.A");
		A a = (A)cls.newInstance();
		Field[] as = cls.getDeclaredFields();
		for (int i = 0; i < as.length; i++) {
			System.out.println(as[i].getName()+"\t"+soEasy(as[i].getModifiers())+"\t"+as[i].getType());
		}
	}
}
