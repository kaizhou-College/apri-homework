package com.kz.serlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet03 extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.getParameter("utf-8");
		PrintWriter out = response.getWriter();
		String name=request.getParameter("name");
		String pwd = request.getParameter("pwd");
		request.setAttribute("name", name);
		request.setAttribute("pwd", pwd);
		request.getRequestDispatcher("servlet03_2.jsp").forward(request, response);
	}
}
