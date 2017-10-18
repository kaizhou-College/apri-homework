package com.kz.anno;

import java.lang.annotation.Annotation;

public class TestAnno {
	public static void main(String[] args) {
		Class clazz = UserInfoTest.class;
		UserInfo userInfo = (UserInfo) clazz.getAnnotations()[0];
		//获取username属性
		System.out.println(userInfo.username());
		//获取passward属性
		System.out.println(userInfo.value());
	}
}
