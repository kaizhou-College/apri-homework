package com.kqw;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 
 * @author 
 * дһ�����ӣ�����filter��servlet����������
 */
public class MyFilter1 implements Servlet{
	
	public MyFilter1(){
		System.out.println("MyFilter1��������");
	}
	
	
	public void destroy() {
		System.out.println("MyFilter1��������");
	}

	public ServletConfig getServletConfig() {
		
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("MyFilter1��ʼ��");
		
	}

	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
			System.out.println("����ʼ��");
		
	}

}
