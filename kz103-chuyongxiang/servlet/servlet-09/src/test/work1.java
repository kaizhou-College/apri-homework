package test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import entity.A;

public class work1 {
	public static void main(String[] args) throws Exception {
		System.out.println("------------------- Ù–‘------------------");
		Class clazz=Class.forName("entity.A");
		A a=(A) clazz.newInstance();
		Field[] fields=clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println(soEasy(fields[i].getModifiers())+"\t"+getTypes(fields[i].getType())
					+"\t"+fields[i].getName());
		}
		System.out.println("-------------------∑Ω∑®-------------------");
		Method[] methods = clazz.getDeclaredMethods();
		for(int i=0;i<methods.length;i++){
			System.out.println(soEasy(methods[i].getModifiers())+"\t"
					+getTypes(methods[i].getReturnType())+"\t"
					+methods[i].getName()+"("
					+getPTypes(methods[i].getParameterTypes())+")\t");
		}
	}

	public static String soEasy(int modify){
		return Modifier.toString(modify);
	}
	public static String getTypes(Class Type){
		StringBuffer sb = new StringBuffer();
		String type = Type.getSimpleName();
		sb.append(type);
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
}
