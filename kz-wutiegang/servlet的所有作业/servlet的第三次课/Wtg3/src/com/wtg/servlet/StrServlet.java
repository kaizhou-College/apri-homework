package com.wtg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class StrServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = res.getWriter();
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String workaddress=req.getParameter("workaddress");
		out.print(name+"\t"+address+"\t"+workaddress);
	}

}
