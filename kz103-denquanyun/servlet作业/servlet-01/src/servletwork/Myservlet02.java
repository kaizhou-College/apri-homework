package servletwork;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//2.写一个类实现Servlet接口,测试servlet的生命周期

public class Myservlet02 implements Servlet{
	
	public Myservlet02(){//出生
		System.out.println("servlet出生了");
	}
	public void destroy() {//销毁了
		// TODO Auto-generated method stub
		System.out.println("servlet销毁了");
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.getServletConfig();
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "测试";
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("servlet培训了");
	}

	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("servlet服务了");

	}

}
