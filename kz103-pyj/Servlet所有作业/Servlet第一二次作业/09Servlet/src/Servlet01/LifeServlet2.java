package Servlet01;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LifeServlet2 extends GenericServlet{
	public void LifeServlet2(){
		System.out.println("LifeServlet2被创建...");
	}
	//销毁
	public void destroy() {
		System.out.println("LifeServlet2被销毁...");
	}
//得到配置
	public ServletConfig getServletConfig() {
		return null;
	}
//
	public String getServletInfo() {
		return null;
	}
//初始化(培训)
	public void init() throws ServletException {
		System.out.println("LifeServlet2初始化...");
	}
	//服务	
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("开始服务...");
		
	}

}
