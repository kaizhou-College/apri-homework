package com.tl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 通过request对象获取所有属性
 * QQ：279470650
 * 
 * @author Administrator
 *
 */
public class MyServlet3 extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		response.setContentType("text/html;charset=utf-8");;;;;;;;;
		//response.setContentType("application/vnd.ms-excel;charset=utf-8");;;;;;;;;
		PrintWriter out = response.getWriter();
		
		Enumeration<String>  enume = request.getAttributeNames();
		out.write("<table border='1'>"+enume.hasMoreElements());
		
		while (enume.hasMoreElements()) {
			out.write("<tr>");
			String key = (String) enume.nextElement();
			out.write("<td>"+key+"</td>");
			
			Object value = request.getAttribute(key);
			out.write("<td>"+value.toString()+"</td>");
			
			out.write("</tr>");
		}
		out.write("</table>");
		//request.getRequestURI();
		//request.getRemoteAddr();
//		/request.getServletPath();
	}
	
	
	
	
}
