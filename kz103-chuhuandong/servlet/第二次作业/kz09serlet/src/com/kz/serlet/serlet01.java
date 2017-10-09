package com.kz.serlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class serlet01 implements Servlet{
	static int num=0;
	public static void main(String[] args) {

	}
	@Override
	public void destroy() {
		System.out.println("销毁了...");
	}
	@Override
	public ServletConfig getServletConfig() {
		return this.getServletConfig();
	}
	@Override
	public String getServletInfo() {
		return "我是myservlet02 我用来测试servetl的声明周期";
	}
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("初始化了...");
		
	}
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
			num+=1;
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("怪你过份美丽如毒蛇狠狠箍紧彼此关系"+"   运行次数"+num);
			System.out.println("服务器运行了");
	}
}
