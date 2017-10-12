package com.kz.test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.kz.entity.Student;

/**
 * 通过Class类获取类中的属性：
 * getMethod()-------------获取指定公有方法
 * getMethods()------------获取所有公有方法
 * getDeclaredMethod()-----获取指定非公有方法
 * getDeclaredMethods()----获取所有非公有方法
 * getName()-------------获取方法名字
 * @author mr.chan
 *
 */
public class Test2 {
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("com.kz.entity.Student");
		//得到对象
		Student s = (Student) clazz.newInstance();
		//1,获取指定公有方法   类的方法有一个类与之对应：method类
		//参数1：方法的名字  参数2：方法参数的class类型：
		Method setName = clazz.getMethod("setName", new Class[]{String.class});
		//2,调用方法：s.setName("二狗子");
		setName.invoke(s,new String[]{"二狗子"});
		//3, 获取getName方法
		Method getName = clazz.getMethod("getName", null);
		//4,调用getName方法
		System.out.println(getName.invoke(s, null));
		//1,2获取所有非公有方法
		Method[] methods = clazz.getDeclaredMethods();
		for(int i=0;i<methods.length;i++){
			System.out.println(soEasy(methods[i].getModifiers())+"\t"
					+getTypes(methods[i].getReturnType())+"\t"
					+methods[i].getName()+"("
					+getPTypes(methods[i].getParameterTypes())+")\t");
		}
		
		//1.3获取指定非公有方法
		Method tla =clazz.getDeclaredMethod("谈恋爱", new Class[]{int.class,String.class,double.class});
		//暴力破解封装
		tla.setAccessible(true);
		
		tla.invoke(s, 1,"2",1);
		///--------------可变参数
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
