package com.kz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		//1,Ҫ���û���������---session
		req.getSession().setAttribute("uname",uname);
		//2������admin.jspҳ�� �������Ҫ���ض��� 
		resp.sendRedirect("admin/admin.jsp");
		
	}

}
