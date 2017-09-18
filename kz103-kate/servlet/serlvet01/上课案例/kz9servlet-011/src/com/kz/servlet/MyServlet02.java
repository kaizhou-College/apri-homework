package com.kz.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * servlet的生命周期(什么创建， 什么销毁)
 * 构造方法		出生的方法  调用一次页只会调用一次
 * 	单列模式----一个类只能new一个对象
 * init()		初始化方法  调用一次
 * service() 	服务的方法  多少次请求就调用多少次
 * destroy()	销毁的方法  
 * 
 * 
 */
public class MyServlet02 implements Servlet {
	private ServletConfig servletConfig;
	
	///构造方法
	public MyServlet02(){
		System.out.println("MyServlet02被创建了");
	}
	//销毁的方法
	@Override
	public void destroy() {
		//收尾工作 -关流 对象的销毁
		System.out.println("MyServlet02被销毁了");
	}
	//得到servlet的配置(芳龄，三围....)
	
	@Override
	public ServletConfig getServletConfig() {
		return this.servletConfig;
	}
	//得到servlet的信息
	@Override
	public String getServletInfo() {
		return "我是myservlet02 我用来测试servetl的声明周期";
	}
	//初始化(培训)
	/*当web容器去创建当前servlet这个类的时候，
	 * 将servlet的配置信息读取，并且将信息封装到一个
	 * ServletConfig类的对象身上，web容器再将这个对象
	 * 传给init方法当参数
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Myservlet02初始化了....");
		//进行servlet对象的初始化
		this.servletConfig = config;
		
	}
	//服务的方法
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("服务了");
		ServletConfig config = getServletConfig();
		String age = config.getInitParameter("age");
		String encode = config.getInitParameter("encode");
		System.out.println("age==="+age+"---->"+"encode===="+encode);;
	}

}
