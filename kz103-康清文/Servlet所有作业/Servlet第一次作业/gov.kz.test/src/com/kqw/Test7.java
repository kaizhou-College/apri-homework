package com.kqw;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 
 * @author 
 * дһ����̳�GenericServlet,����servlet����������
 */
public class Test7 extends GenericServlet{

private ServletConfig servletConfig;
	
	//���췽��
	public Test7(){
		System.out.println("Servlet������������");
	}

	//���ٵķ���
	public void destroy() {
		System.out.println("Servlet������������");
		
	}

	
	public ServletConfig getServletConfig() {
		return this.servletConfig;
		
	}
	//�õ�servlet����Ϣ
	public String getServletInfo() {
		return "����Test2,��������Servlet����������";
		
	}

	//����servlet����ĳ�ʼ��
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Test2�������г�ʼ��");
		this.servletConfig=config;
	}

	//����ķ���
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
			System.out.println("Test7��ʼ������");
			ServletConfig config=getServletConfig();
			String age=config.getInitParameter("age");
			String encode=config.getInitParameter("encode");
			System.out.println("age===="+age+"====="+"encode===="+encode);
		
	}
		
}
