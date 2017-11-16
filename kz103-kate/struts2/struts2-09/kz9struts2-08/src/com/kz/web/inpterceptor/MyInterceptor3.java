package com.kz.web.inpterceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
//可以指定action的那些方法被拦截
public class MyInterceptor3 extends MethodFilterInterceptor {
	//指定只拦截UsersAction的login方法
	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		System.out.println("进入MyInterceptor3拦截器.....");
		//放行
		arg0.invoke();
		System.out.println("出了MyInterceptor3拦截器.....");
		
		return null;
	}

}
