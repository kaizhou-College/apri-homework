package com.wtg;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.wtg.entity.A;

/**
 * 
 * @author WTG
 * ͨ��Class���ȡ���е����ԣ�
 * getField()-------------��ȡָ����������
 * getFields()------------��ȡ���й�������
 * getDeclaredField()-----��ȡָ���ǹ�������
 * getDeclaredFields()----��ȡ���зǹ�������
 * getName()-------------��ȡ��������
 */
public class Test1 {
	public static void main(String[] args) throws Exception {
		//�ҵ����ĸ��������A��
		Class c1 = Class.forName("com.wtg.entity.A");
		//�õ�����
		A a = (A) c1.newInstance();
		//1.�õ��������ԣ�������һ������֮��Ӧ
		Field fa = c1.getField("a");
		//2.�����Ը�ֵ
		fa.set(a, 1);
		//3.��ȡ����ֵ
		System.out.println(fa.get(a));
		Field fa1 = c1.getDeclaredField("b");
		fa1.setAccessible(true);
		fa1.set(a, 2);
		
		System.out.println(fa1.get(a));
		//�õ���������
		Field[] fields = c1.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println(RPm(fields[i].getModifiers())+"\t"+
					fields[i].getType()+"\t"+fields[i].getName());
		}
		Method showA=c1.getMethod("showA", new Class[]{int.class});
		//���÷���
		System.out.println(showA.invoke(a, new Integer[]{3}));
		Method showB=c1.getDeclaredMethod("showB", null);
		showB.setAccessible(true);
		System.out.println(showB.invoke(a, null));
		//�õ����з���
		Method[] methods = c1.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.println(RPm(methods[i].getModifiers())+"\t"
					+methods[i].getReturnType()+"\t"
					+methods[i].getName()+"();"
					
			);
			
		}
	}
	public static String RPm(int m){
		return Modifier.toString(m);
	}
	
}
