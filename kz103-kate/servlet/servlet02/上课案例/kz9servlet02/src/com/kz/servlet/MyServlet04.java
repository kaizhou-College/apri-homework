package com.kz.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * ServletConfig : 记录单个服务员的信息(单个学生)
 * 
 * ServletContext：记录所有servlet上下文信息(环境--上课的教室)
 * 
 * context :上下文  (环境)
 */
public class MyServlet04 extends HttpServlet{ //implements Servlet{

	/*@Override
	protected void service(ServletRequest req,ServletResponse resp)
			throws ServletException, IOException {
		//获取ServletConfig类对象
		ServletConfig config = getServletConfig();
		System.out.println(config.getInitParameter("encode"));
		
		//获取ServletContext类对象---application对象()
		ServletContext application = this.getServletContext();
		System.out.println(application.getInitParameter("encode"));
	}*/
	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
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

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取ServletConfig类对象
		ServletConfig config = getServletConfig();
		System.out.println(config.getInitParameter("encode"));
		
		//获取ServletContext类对象---application对象()
		//ServletContext application = this.getServletContext();
		ServletContext application = this.getServletConfig().getServletContext();
		System.out.println(application.getInitParameter("encode"));
	}

}
