package com.kqw.Text;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;




public class Test2 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("application/vnd.ms-excel;charset=utf-8");
		PrintWriter out = res.getWriter();
		HttpServletRequest request=(HttpServletRequest)req;
		Enumeration enumeration = request.getHeaderNames();
		while(enumeration.hasMoreElements()){
			String key =(String) enumeration.nextElement();
			String value = request.getHeader(key);
			out.print(key);
			out.print(value);
		}
	}

}
