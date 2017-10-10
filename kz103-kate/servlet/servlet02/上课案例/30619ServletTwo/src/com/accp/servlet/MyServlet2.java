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
		//��������:ctrl+alt+����
		//����:alt+����
		//��ʽ��:ctrl+shift+f
		
		//ǿתrequest����
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		//����html��ʽ����Ӧ
		//response.setContentType("text/html;charset=utf-8");
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		PrintWriter  out = response.getWriter();
		
		//����request���󣬻�ȡ����ͷname�ļ���
		//������һ����������
		Enumeration<String> ems = request.getHeaderNames();
		out.println("<table border='1' borderColor='red'>");
		while(ems.hasMoreElements()){
			//��ȡÿ������ͷname
			String name = ems.nextElement();
			//����name��ȥ����ͷ���õ���Ӧ��vlaueֵ
			String value = request.getHeader(name);
			out.println("<tr>");
			out.println("<td>"+name+"</td>");
			out.println("<td>"+value+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		
	}

	
}
