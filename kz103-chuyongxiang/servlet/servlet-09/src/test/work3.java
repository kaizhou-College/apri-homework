package test;

import java.lang.reflect.Constructor;

import entity.B;

public class work3 {
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("entity.B");
		//��һ
		B b = (B) clazz.newInstance();
		//�ڶ�
		Constructor constructor = clazz.getDeclaredConstructor(int.class);
		B b1 = (B) constructor.newInstance(1);
		//����
		Constructor constructor2 = clazz.getDeclaredConstructor(Integer.class);
		B b2 = (B) constructor2.newInstance(15);
	}
}
