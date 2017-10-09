package com.kqw;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.core.Config;

import org.omg.CORBA.Request;

import com.sun.net.httpserver.HttpServer;
/**
 * 
 * @author 
 * 从一个jsp页面上使用post方式提交一个用户编号，一个用户名，和爱好的两个复选项到Servlet，
 * Servlet接收后处理编码问题，输出到控制台。(继承GenericServlet)
 */
public class Test4 extends GenericServlet{
	private ServletConfig ServletConfig;
	
	public ServletConfig getServletConfig() {
		return this.ServletConfig;
		
	}
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Myservlet02初始化了....");
		//进行servlet对象的初始化
		this.ServletConfig = config;
		
	}
	//服务的方法
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
			System.out.println("Test4开始服务了");
			res.setContentType("text/html;charset=utf-8");
			ServletConfig config=getServletConfig();
			String hobby = config.getInitParameter("hobby");
			String hobbyy=config.getInitParameter("hobbyy");
			//编码问题
			//获取提交方式：request对象
			HttpServletRequest request=(HttpServletRequest)req;
			String method = request.getMethod();
			//获取servlet的编码配置
			String encode=getServletConfig().getInitParameter("encode");
			//post提交编码
			String name =null;
			String pwd = null;
			if(method.equalsIgnoreCase("post")){
				req.setCharacterEncoding(encode);
				name = req.getParameter("name");
				pwd = req.getParameter("pwd");
			}else{//get提交
				name = req.getParameter("name");
				name = new String(name.getBytes("iso-8859-1"),"utf-8");
				pwd = req.getParameter("pwd");
				pwd = new String(pwd.getBytes("iso-8859-1"),"utf-8");
			
			}
			
			System.out.println("name===="+name+"pwd===="+pwd);
			System.out.println("hobby==="+hobby+"---->"+"hobbyy===="+hobbyy);;
	}
	
		
	
	
}
