package com.kz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class servlet05 extends GenericServlet{
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		res.setContentType("textml;charset=utf-8");
		PrintWriter out = res.getWriter();
		ServletConfig config = this.getServletConfig();
		ServletContext context = this.getServletContext();
		Enumeration enumeration= config.getInitParameterNames();
		while(enumeration.hasMoreElements()){
			String key = (String) enumeration.nextElement();
			String value = config.getInitParameter(key);
			out.print(key+"---"+value+"<br/>");
		}
		out.print("----------------------------<br/>");
		Enumeration enumeration2 = context.getInitParameterNames();
		while(enumeration2.hasMoreElements()){
			String key = (String) enumeration2.nextElement();
			String value = context.getInitParameter(key);
			out.print(key+"---"+value+"<br/>");
		}
	}
}
