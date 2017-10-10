package com.accp.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * ServletContext��ServletConfig֮�������
 * ServletContext:Servlet������(����)
 * ServletConfig:ServletConfig(servlet�����������Ϣ)
 * @author Administrator
 *
 */
public class MyServlet5 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		
		ServletContext context = this.getServletContext();
		ServletConfig config = this.getServletConfig();
		
		//��config����Ϣ
		//��ȡinit-param���������е�name�ĵ�������
		Enumeration<String> ems = config.getInitParameterNames();
		while(ems.hasMoreElements()){
			//�ó�param-name�е�ֵ 
			String name = ems.nextElement();
			//����name��ȡparam-value��ֵ
			String value = config.getInitParameter(name);
			System.out.println(name+"---"+value);
		}
		
		
		System.out.println("----------------------");
		Enumeration<String> es = context.getInitParameterNames();
		while(es.hasMoreElements()){
			String name = es.nextElement();
			String value = context.getInitParameter(name);
			System.out.println(name+"---"+value);
		}
	}

	
}
