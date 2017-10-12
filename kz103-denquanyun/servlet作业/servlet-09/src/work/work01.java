package work;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
 * дһ�������࣬Ҫ���ڴ����main���������A���е��������ԣ��������η������ͣ���
 * ���������������η����������ͺͲ����б���
 * */
public class work01 {
	public static void main(String[] args) throws Exception{
		Class clazz = Class.forName("work.A");
		A a = (A) clazz.newInstance();
		Field[] fields = clazz.getDeclaredFields();
		Method[] methods = clazz.getDeclaredMethods();
		System.out.println("----����----");
		for (int i = 0; i < fields.length; i++) {
			System.out.println(Modify(fields[i].getModifiers())+" "+fields[i].getType()+" "+fields[i].getName());
		}
		System.out.println("----����----");
		for (int i = 0; i < methods.length; i++) {
			System.out.println(Modify(methods[i].getModifiers())+" "+getRType(methods[i].getReturnType())+" "+methods[i].getName()+"("+getPType(methods[i].getParameterTypes())+")");
		}
	}
	public static String Modify(int modify){
		return Modifier.toString(modify);
	}
	public static String getPType(Class[] clazz){
		StringBuffer str = new StringBuffer();
		for (int i = 0; i <clazz.length; i++) {
			str.append(clazz[i].getSimpleName());
			if(i!=clazz.length-1){
				str.append(",");	
			}
		}
		return str.toString();
	}
	public static String getRType(Class clazz){
		StringBuffer str = new StringBuffer();
		String string = clazz.getName().toString();
		str.append(string);
		return str.toString();
	}
}
