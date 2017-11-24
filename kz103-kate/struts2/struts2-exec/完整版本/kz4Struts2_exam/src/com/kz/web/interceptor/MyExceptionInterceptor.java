package com.kz.web.interceptor;

import com.kz.web.exception.MyException;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
//拦截action的方法
public class MyExceptionInterceptor extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation arg0) {
		try {
			//放行
			return arg0.invoke();
		} catch (MyException e) {
			//统一处理系统的异常
			//1,发送短信 2， 发邮件  3，记录日志文件
			System.out.println("这个异常被我拦截了3333..."+e.getMessage());
			return "error";
		}catch (Exception e) {
			//统一处理系统的异常
			//1,发送短信 2， 发邮件  3，记录日志文件
			System.out.println("这个异常被我拦截了2222..."+e.getMessage());
			return "error";
		}
	}

}
