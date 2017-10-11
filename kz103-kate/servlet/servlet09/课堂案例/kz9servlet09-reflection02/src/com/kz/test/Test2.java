package com.kz.test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.kz.entity.Student;

/**
 * ͨ��Class���ȡ���е����ԣ�
 * getMethod()-------------��ȡָ�����з���
 * getMethods()------------��ȡ���й��з���
 * getDeclaredMethod()-----��ȡָ���ǹ��з���
 * getDeclaredMethods()----��ȡ���зǹ��з���
 * getName()-------------��ȡ��������
 * @author mr.chan
 *
 */
public class Test2 {
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("com.kz.entity.Student");
		//�õ�����
		Student s = (Student) clazz.newInstance();
		//1,��ȡָ�����з���   ��ķ�����һ������֮��Ӧ��method��
		//����1������������  ����2������������class���ͣ�
		Method setName = clazz.getMethod("setName", new Class[]{String.class});
		//2,���÷�����s.setName("������");
		setName.invoke(s,new String[]{"������"});
		//3, ��ȡgetName����
		Method getName = clazz.getMethod("getName", null);
		//4,����getName����
		System.out.println(getName.invoke(s, null));
		//1,2��ȡ���зǹ��з���
		Method[] methods = clazz.getDeclaredMethods();
		for(int i=0;i<methods.length;i++){
			System.out.println(soEasy(methods[i].getModifiers())+"\t"
					+getTypes(methods[i].getReturnType())+"\t"
					+methods[i].getName()+"("
					+getPTypes(methods[i].getParameterTypes())+")\t");
		}
		
		//1.3��ȡָ���ǹ��з���
		Method tla =clazz.getDeclaredMethod("̸����", new Class[]{int.class,String.class,double.class});
		//�����ƽ��װ
		tla.setAccessible(true);
		
		tla.invoke(s, 1,"2",1);
		///--------------�ɱ����
		add(1);
		add(2,3);
		add(1,2,3);
		add(1,2,3,4);
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
	public static String getPTypes(Class[] cls){
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<cls.length;i++){
			sb.append(cls[i].getSimpleName());
			if(i!=cls.length-1){
				sb.append(",");	
			}
			
		}
		return sb.toString();
	}
	public static void add(Integer... args){
		int sum =0;
		for(int i=0;i<args.length;i++){
			sum+=args[i];
		}
		System.out.println("sum==="+sum);
	}
	
}
