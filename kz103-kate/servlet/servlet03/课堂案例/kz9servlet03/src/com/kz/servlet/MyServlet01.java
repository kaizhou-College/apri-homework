package com.kz.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class MyServlet01 implements Servlet{
	public MyServlet01(){
		System.out.println("MyServlet01出生了");
	}

	public void destroy() {
		System.out.println("MyServlet01 销毁的了");
		
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null;
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("MyServlet01 初始化的了");
		
	}
	int i ;
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("MyServlet01 开始服务的了");
		i++;
	}
}
