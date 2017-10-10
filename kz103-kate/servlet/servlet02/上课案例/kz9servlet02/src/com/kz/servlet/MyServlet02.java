package com.kz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;
//��ȡ����ͷ��Ϣ
public class MyServlet02 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//resp.setContentType("text/html;charset=utf-8");
		//excel�ĸ�ʽչʾ����
		resp.setContentType("application/vnd.ms-excel;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		//1,����ͷ��Ϣ
		Enumeration enumeration = req.getHeaderNames();
		out.print("<table border='1'>");
		while(enumeration.hasMoreElements()){
			out.print("<tr>");
			String key = (String) enumeration.nextElement();
			String value = req.getHeader(key);
			System.out.println("key----"+key+"value----"+value);
			
			out.print("<td>"+key+"</td>");
			
			out.print("<td>"+value+"</td>");
			out.print("</tr>");
		}
		out.print("</table>");
	}
}
