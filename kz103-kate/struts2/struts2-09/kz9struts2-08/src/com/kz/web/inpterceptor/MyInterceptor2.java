package com.kz.web.inpterceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sun.net.httpserver.Filter.Chain;
//����action�����з���
public class MyInterceptor2 extends AbstractInterceptor{
	//������--����action����(����---��������й���)-----����������������(����----����)
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("����������.....");
		//����----ȥ���£�ȥ����action�ķ�����
		invocation.invoke();
		
		System.out.println("����������....");
		return null;
	}

}
