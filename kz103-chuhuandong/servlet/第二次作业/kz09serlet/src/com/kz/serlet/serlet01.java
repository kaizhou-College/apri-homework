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
		System.out.println("������...");
	}
	@Override
	public ServletConfig getServletConfig() {
		return this.getServletConfig();
	}
	@Override
	public String getServletInfo() {
		return "����myservlet02 ����������servetl����������";
	}
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("��ʼ����...");
		
	}
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
			num+=1;
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("������������綾�ߺݺݹ����˴˹�ϵ"+"   ���д���"+num);
			System.out.println("������������");
	}
}
