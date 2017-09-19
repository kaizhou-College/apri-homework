package com.accp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet2 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//复制下移:ctrl+alt+下移
		//下移:alt+下移
		//格式化:ctrl+shift+f
		
		//强转request对象
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		//设置html方式的响应
		//response.setContentType("text/html;charset=utf-8");
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		PrintWriter  out = response.getWriter();
		
		//根据request请求，获取请求头name的集合
		//返回是一个迭代集合
		Enumeration<String> ems = request.getHeaderNames();
		out.println("<table border='1' borderColor='red'>");
		while(ems.hasMoreElements()){
			//获取每个请求头name
			String name = ems.nextElement();
			//根据name，去请求头中拿到对应的vlaue值
			String value = request.getHeader(name);
			out.println("<tr>");
			out.println("<td>"+name+"</td>");
			out.println("<td>"+value+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		
	}

	
}
