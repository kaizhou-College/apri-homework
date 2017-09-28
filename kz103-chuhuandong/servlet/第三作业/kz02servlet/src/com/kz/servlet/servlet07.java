package com.kz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class servlet07 extends GenericServlet{

//	7.写一个servlet（继承GenericServlet),从请求中的头信息中找到主机地址的信息，然后打印到客户端
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		HttpServletRequest request = (HttpServletRequest)req;
		Enumeration names = request.getHeaderNames();
		while(names.hasMoreElements()){
			String key = (String) names.nextElement();
			if(key.equals("host")){
				out.print(request.getHeader(key));
			}
		}
	}
}
