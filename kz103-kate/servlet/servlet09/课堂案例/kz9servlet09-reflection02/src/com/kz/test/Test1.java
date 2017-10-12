package com.kz.test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.kz.entity.Student;

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
public class Test1 {
	public static void main(String[] args) throws Exception {
	
		Class clazz = Class.forName("com.kz.entity.Student");
		//�õ�����
		Student s = (Student) clazz.newInstance();
		//1,�õ���������:������һ������֮��Ӧ
		Field fsex =clazz.getField("sex");
		//2,�����Ը�ֵ  
		fsex.set(s, "Ů");//s.setSex("Ů");
		//3,��ȡ����ֵ		s.getSex();
		System.out.println(fsex.get(s));
		//1.2�õ���������
		Field[] fields = clazz.getDeclaredFields();
		for(int i=0;i<fields.length;i++){
			System.out.println(soEasy(fields[i].getModifiers())+
					"\t"+getTypes(fields[i].getType())
					+"\t"+fields[i].getName());
		}
		/*Field fname = clazz.getDeclaredField("name");
		//�����ƽ��װ
		fname.setAccessible(true);
		
		fname.set(s, "������"); //s.setName("������");
		System.out.println(fname.get(s));*/
		
		
	}
	public static String soEasy(int modify){
		/*if(modify==0){
			return "";
		}else if(modify==1){
			return "public" ;
		}else if(modify==2){
			return "private";
		}else{
			return "protected";
		}*/
		return Modifier.toString(modify);
	}
	public static String getTypes(Class Type){
		StringBuffer sb = new StringBuffer();
		String type = Type.getSimpleName();
		sb.append(type);
		//System.out.println(String.class.getSimpleName());
		//System.out.println(String.class.getName());
		return sb.toString();
	}
}
