package com.kz.serlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class servlet02 extends GenericServlet{
	public static void main(String[] args) {
		
	}
	@Override
	public void destroy() {
		System.out.println("服务器销毁了。。。");
	}
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}
	@Override
	public String getServletInfo() {
		return null;
	}
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("初始化了");
	}
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
			System.out.println("服务器启动了");
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String number = request.getParameter("number");
			String name = request.getParameter("name");
			String[] hobby = request.getParameterValues("hobby");
			System.out.println(number);
			System.out.println(name);
			for (int i = 0; i < hobby.length; i++) {
				System.out.println(hobby[i]+"");
			}
	}
}
