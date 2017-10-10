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
		//ǿ��
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response =(HttpServletResponse)res;
		
		//ͨ��request���󣬻�ȡrequest�����е�����name����
		//request��API
		Enumeration<String> ems =  request.getAttributeNames();
		while(ems.hasMoreElements()){
			String name = ems.nextElement();
			String value  = (String)request.getAttribute(name);
			System.out.println(name+":"+value);
		}
		
		//������request�л�ȡ��Դ·���ļ��ַ�ʽ
		//���·��
		//   /30619SevletTwo/MyServlet3
		System.out.println(request.getRequestURI());
		//  http://localhost:8080/30619ServletTwo/MyServlet3
		System.out.println(request.getRequestURL());
		
		//��ȡ��Ŀ��
		//  /306109ServletTwo
		System.out.println(request.getContextPath());
		
		//��ǰ����Դ·��
		System.out.println(request.getServletPath());
			
		
		//��ȡָ����Դ�ڷ������о���·��
		// ""��ʾ�ǻ�ȡ��Ŀ�ĸ�·��
		//System.out.println(request.getRealPath(""));
		System.out.println(request.getRealPath("/WEB-INF/web.xml"));
	}

	
}
