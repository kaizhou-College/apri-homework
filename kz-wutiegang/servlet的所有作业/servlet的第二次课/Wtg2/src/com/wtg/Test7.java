package com.wtg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class Test7 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//将req强制转换成http协议
		HttpServletRequest request=(HttpServletRequest)req;
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		//得到头部的所有信息
		Enumeration enumeration = request.getHeaderNames();
		//根据头部的信息查出其主机地址
	StringBuffer requestURL = request.getRequestURL();
		out.print(requestURL);
		/*String requestURI = request.getRequestURI();
		out.print(requestURI);*/
		/*while(enumeration.hasMoreElements()){
			String key =(String) enumeration.nextElement();
			String[] values=request.getParameterValues(key);
			
		}*/
		
		
	}

}
