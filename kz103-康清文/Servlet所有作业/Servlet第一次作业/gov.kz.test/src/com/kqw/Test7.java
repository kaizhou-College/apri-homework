package com.kqw;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 
 * @author 
 * 写一个类继承GenericServlet,测试servlet的生命周期
 */
public class Test7 extends GenericServlet{

private ServletConfig servletConfig;
	
	//构造方法
	public Test7(){
		System.out.println("Servlet方法被创建了");
	}

	//销毁的方法
	public void destroy() {
		System.out.println("Servlet方法被销毁了");
		
	}

	
	public ServletConfig getServletConfig() {
		return this.servletConfig;
		
	}
	//得到servlet的信息
	public String getServletInfo() {
		return "我是Test2,用来测试Servlet的生命周期";
		
	}

	//进行servlet对象的初始化
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Test2方法进行初始化");
		this.servletConfig=config;
	}

	//服务的方法
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
			System.out.println("Test7开始服务了");
			ServletConfig config=getServletConfig();
			String age=config.getInitParameter("age");
			String encode=config.getInitParameter("encode");
			System.out.println("age===="+age+"====="+"encode===="+encode);
		
	}
		
}
