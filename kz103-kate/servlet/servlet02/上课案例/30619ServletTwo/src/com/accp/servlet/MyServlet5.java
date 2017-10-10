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
 * ServletContext和ServletConfig之间的区别
 * ServletContext:Servlet上下文(环境)
 * ServletConfig:ServletConfig(servlet自身的配置信息)
 * @author Administrator
 *
 */
public class MyServlet5 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		
		ServletContext context = this.getServletContext();
		ServletConfig config = this.getServletConfig();
		
		//获config的信息
		//获取init-param中配置所有的name的迭代集合
		Enumeration<String> ems = config.getInitParameterNames();
		while(ems.hasMoreElements()){
			//拿出param-name中的值 
			String name = ems.nextElement();
			//根据name获取param-value的值
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
