package com.kz.test;

import java.util.Hashtable;

public class work03 {
	public static void main(String[] args) {
		Class cls = Hashtable.class;
		while(cls!=null){
			System.out.println(cls.getName());
			cls = cls.getSuperclass();
		}
	}
}
