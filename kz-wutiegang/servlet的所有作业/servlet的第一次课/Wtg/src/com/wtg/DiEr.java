package com.wtg;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DiEr implements Servlet{
	private ServletConfig servletConfig;
/**
 * servlet的生命周期（从什么时候创建，什么时候销毁）
 * 构造方法  出生的方法
 * destroy方法 销毁的方法
 * init()方法    初始化的方法只调用一次
 * service服务的方法      请求多少次就调用多少次
 */
	//构造方法
	public DiEr(){
		System.out.println("DiEr被创建了");
	}
	//销毁的方法
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("DiEr被销毁了");
	}
	//得到servlet的配置信息
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.servletConfig;
	}
	//得到servlet的信息
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "servlet的信息";
	}
	//初始化
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("DiEr初始化了");
		this.servletConfig=config;
	}
	//服务方法
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("服务了");
		ServletConfig Config = getServletConfig();
		String age=Config.getInitParameter("age");
		String encode=Config.getInitParameter("encode");
		System.out.println(age+encode);
	}

}
