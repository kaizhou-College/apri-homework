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
 * 写一个类实现Servlet接口,统计此servlet被请求了多少次，输出到客户端,在销毁此Servlet的时候，将请求次数写到
      硬盘的文本文档中.
	
 */
public class Test3 implements Servlet{

	private ServletConfig ServletConfig;

	//构造方法
	public Test3(){
		System.out.println("Servlet方法被创建了");
		
	}
	
	//销毁的方法
	public void destroy() {
		System.out.println("Servlet方法被销毁了");
		
	}
	
	public ServletConfig getServletConfig() {
		return this.ServletConfig;
		
	}
	//得到servlet的信息
	public String getServletInfo() {
		return "我是Test3,用来测试Servlet的生命周期";
		
	}

	//进行servlet对象的初始化
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Test3方法进行初始化");
		this.ServletConfig=config;
	}


	//服务的方法
	int i;
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
			System.out.println("Test3开始服务了");
			ServletConfig config=getServletConfig();
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out=res.getWriter();
			i++;
			out.print("servlet被请求了"+i+"多少次");
			
		
	}

}
