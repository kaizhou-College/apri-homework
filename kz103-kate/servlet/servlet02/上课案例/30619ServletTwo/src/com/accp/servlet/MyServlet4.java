package com.accp.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyServlet4 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		HttpServletRequest request =(HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		//��request�д������ֵ 
		String rname = (String)request.getAttribute("name");
		
		
		//��ȡsession�е�ֵ
		HttpSession session = request.getSession();
		String sname = (String)session.getAttribute("name");
		
		
		//��ȡapplication�е�ֵ
		//���ֻ�ȡapplication�ķ�ʽ��ֻ�ʺ�����GenericServlet��HttpServlet������Ӧ��
		ServletContext applcation = this.getServletContext();
		//����Զ�����ʵ�� servlet�ӿڣ���ô��Ҫ�����·�ʽ:
		//ServletContext application = this.getServletConfig().getServletContext();
	 	String aname =  (String)applcation.getAttribute("name");
	
	 	System.out.println("request:"+rname);
	 	System.out.println("session:"+sname);
	 	System.out.println("application:"+aname);
	 	
	 	
	 	//jsp���ö���--------------Servlet�е���
	 	//request----------------HttpServletRequest
	 	//response---------------HttpServletResponse
	 	//session----------------HttpSession
	 	//application------------ServletContext
	 	//out--------------------JspWriter
	 	//pageContext------------PageContext
	 	//config-----------------ServletConfig
	 	//exection---------------JspException
	 	//page-------------------JspPage
	 	
	 	
	 	
	}

}
