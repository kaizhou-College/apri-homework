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
		
		//获request中存的属性值 
		String rname = (String)request.getAttribute("name");
		
		
		//获取session中的值
		HttpSession session = request.getSession();
		String sname = (String)session.getAttribute("name");
		
		
		//获取application中的值
		//这种获取application的方式，只适合于在GenericServlet或HttpServlet的子类应用
		ServletContext applcation = this.getServletContext();
		//如果自定义是实现 servlet接口，那么需要按如下方式:
		//ServletContext application = this.getServletConfig().getServletContext();
	 	String aname =  (String)applcation.getAttribute("name");
	
	 	System.out.println("request:"+rname);
	 	System.out.println("session:"+sname);
	 	System.out.println("application:"+aname);
	 	
	 	
	 	//jsp内置对象--------------Servlet中的类
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
