package com.wtg;

import com.wtg.entity.A;



public class Test2 {
	public static void main(String[] args) {
		//延时加载
		try {
			Class c1=A.class;
			A a=(A) c1.newInstance();
			System.out.println(a.toString());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//及时加载
		try {
			Class c2 = Class.forName("com.wtg.entity.A");
			A a1 = (A) c2.newInstance();
			System.out.println(a1.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
