package com.wtg;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DiBa extends GenericServlet{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("服务开始了");
		ServletConfig config = getServletConfig();
		String age=config.getInitParameter("age");
		String encode=config.getInitParameter("encode");
		System.out.println(age+"=="+encode);
	}

}
