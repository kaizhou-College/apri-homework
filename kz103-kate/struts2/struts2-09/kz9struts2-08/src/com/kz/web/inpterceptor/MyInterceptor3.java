package com.kz.web.inpterceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
//����ָ��action����Щ����������
public class MyInterceptor3 extends MethodFilterInterceptor {
	//ָ��ֻ����UsersAction��login����
	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		System.out.println("����MyInterceptor3������.....");
		//����
		arg0.invoke();
		System.out.println("����MyInterceptor3������.....");
		
		return null;
	}

}
