package com.kz.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class MyServlet01 implements Servlet{
	public MyServlet01(){
		System.out.println("MyServlet01������");
	}

	public void destroy() {
		System.out.println("MyServlet01 ���ٵ���");
		
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null;
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("MyServlet01 ��ʼ������");
		
	}
	int i ;
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("MyServlet01 ��ʼ�������");
		i++;
	}
}
