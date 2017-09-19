package com.accp.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet3 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//强制
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response =(HttpServletResponse)res;
		
		//通过request对象，获取request中所有的属性name集合
		//request的API
		Enumeration<String> ems =  request.getAttributeNames();
		while(ems.hasMoreElements()){
			String name = ems.nextElement();
			String value  = (String)request.getAttribute(name);
			System.out.println(name+":"+value);
		}
		
		//关于在request中获取资源路径的几种方式
		//相对路径
		//   /30619SevletTwo/MyServlet3
		System.out.println(request.getRequestURI());
		//  http://localhost:8080/30619ServletTwo/MyServlet3
		System.out.println(request.getRequestURL());
		
		//获取项目名
		//  /306109ServletTwo
		System.out.println(request.getContextPath());
		
		//当前的资源路径
		System.out.println(request.getServletPath());
			
		
		//获取指定资源在服务器中绝对路径
		// ""表示是获取项目的根路径
		//System.out.println(request.getRealPath(""));
		System.out.println(request.getRealPath("/WEB-INF/web.xml"));
	}

	
}
