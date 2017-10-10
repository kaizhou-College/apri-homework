package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet_01 implements Servlet {
	public Servlet_01() {
		// TODO Auto-generated constructor stub
		System.out.println("servlet_01被创建了");
	}
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("销毁了servlet_01");
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.getServletConfig();
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return getServletInfo()+"是声明生命周期的";
	}

	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("servlet_01更新中");
	}

	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}


}
