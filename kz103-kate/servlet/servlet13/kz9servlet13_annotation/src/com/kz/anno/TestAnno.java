package com.kz.anno;

import java.lang.annotation.Annotation;

public class TestAnno {
	public static void main(String[] args) {
		Class clazz = UserInfoTest.class;
		UserInfo userInfo = (UserInfo) clazz.getAnnotations()[0];
		//��ȡusername����
		System.out.println(userInfo.username());
		//��ȡpassward����
		System.out.println(userInfo.value());
	}
}
