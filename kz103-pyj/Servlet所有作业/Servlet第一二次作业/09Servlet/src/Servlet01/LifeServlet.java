package Servlet01;
//2.写一个类实现Servlet接口,测试servlet的生命周期
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LifeServlet implements Servlet{
	private ServletConfig servletConfig;
//构造方法
	public  LifeServlet(){
		System.out.println("LifeServlet被创建...");
	}
//销毁
	public void destroy() {
		System.out.println("LifeServlet被销毁...");
	}
//得到配置
	public ServletConfig getServletConfig() {
		return this.servletConfig;
	}
//得到servlet信息
	public String getServletInfo() {
		return "我是LifeServlet，我用来测试LifeServlet的生命周期...";
	}
//初始化
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LifeServlet初始化...");
		//进行对象初始化
		this.servletConfig=config;
	}
//服务
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("LifeServlet开始服务...");
	}

}
