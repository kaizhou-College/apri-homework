package com.wtg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DiSan implements Servlet{
	private ServletConfig ServletConfig;
	public int count=0;
	public DiSan(){
		System.out.println("DiSan��������");
		count++;
	}
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("DiSan��������");
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.ServletConfig;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "servlet����Ϣ";
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("��ʼ����������");
		count++;
		this.ServletConfig=config;
	}

	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("���񷽷���������");
		count++;
		ServletConfig Config = getServletConfig();
		String age=Config.getInitParameter("age");
		String encode=Config.getInitParameter("encode");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print("<html>" +
				"<head></head>" +
				"<body>" +
				"");
		out.print("��������"+count+"��");
		out.print("</body></html>");
		res.setContentType("text/html;charset=utf-8");
		System.out.println(age+encode+"    "+count);
		
	}

}
