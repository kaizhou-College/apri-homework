package com.kqw;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 
 * @author 
 * 写一个例子，测试filter和servlet的生命周期
 */
public class MyFilter1 implements Servlet{
	
	public MyFilter1(){
		System.out.println("MyFilter1被创建了");
	}
	
	
	public void destroy() {
		System.out.println("MyFilter1被销毁了");
	}

	public ServletConfig getServletConfig() {
		
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("MyFilter1初始化");
		
	}

	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
			System.out.println("服务开始了");
		
	}

}
