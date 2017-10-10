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
 * 写一个类实现Servlet接口，然后向客户端输出一段歌词的信息，要输出时解决中文乱码问题。
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

	//服务的方法
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out=res.getWriter();
			out.print("我能送你回家吗，可能外面要下雨了");
	}

	
	
	
}
