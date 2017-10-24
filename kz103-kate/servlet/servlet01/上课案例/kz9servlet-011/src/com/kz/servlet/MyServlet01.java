package com.kz.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.xml.ws.Response;

public class MyServlet01 implements Servlet{
	@Override
	public void destroy() {
	}
	
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	//提供服务的方法
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//向控制台输出
		System.out.println("MyServlet01 在为客户端服务......");
		//向页面输出--out是jsp的内置对象 不是servlet的内置对象
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print("MyServlet01 在为客户端服务......");
	}

}
