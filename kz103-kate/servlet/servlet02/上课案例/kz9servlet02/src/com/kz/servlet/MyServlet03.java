package com.kz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet03 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//req.getAttribute("");
		Enumeration enumeration = req.getAttributeNames();
		while(enumeration.hasMoreElements()){
			String key = (String) enumeration.nextElement();
			Object value = req.getAttribute(key);
			System.out.println(key+"----"+value+"\n");
		}
		
		//请求相对路径
		String path1 = req.getRequestURI();
		//请求绝对路径
		StringBuffer path4 = req.getRequestURL();
		//工程名
		String path2  = req.getContextPath();
		//资源名称
		String path3 = req.getServletPath();
		System.out.println(path1+"\t"+path2+"\t"+path3+"\t"+path4.toString());
		
		//服务器的磁盘路径
		String root = req.getRealPath("\\WEB-INF\\web.xml");
		System.out.println(root);
		
		ServletConfig config = getServletConfig();
		System.out.println(config.getInitParameter("encode"));
	
		System.out.println("-------------");
		//获取ServletContext类对象---application对象()
		ServletContext application = this.getServletContext();
		System.out.println(application.getInitParameter("encode"));
	}

			
}
