package com.kqw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



/**
 * 
 * @author 
 * дһ����ʵ��Servlet�ӿڣ�Ȼ����ͻ������һ�θ�ʵ���Ϣ��Ҫ���ʱ��������������⡣
 */
public class Test implements Servlet{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	//����ķ���
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out=res.getWriter();
			out.print("��������ؼ��𣬿�������Ҫ������");
	}

	
	
	
}
