package com.kz.web.inpterceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sun.net.httpserver.Filter.Chain;
//拦截action的所有方法
public class MyInterceptor2 extends AbstractInterceptor{
	//拦截器--拦截action请求(保安---进入的所有过程)-----过滤器：拦截请求(门卫----进出)
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("进入拦截器.....");
		//放行----去办事（去调用action的方法）
		invocation.invoke();
		
		System.out.println("出了拦截器....");
		return null;
	}

}
