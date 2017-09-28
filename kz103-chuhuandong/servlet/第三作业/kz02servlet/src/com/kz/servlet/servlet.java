package com.kz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class servlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("username");
		String hobby = request.getParameter("dz");
		HttpSession session = request.getSession();
		System.out.println(name+""+hobby);
		session.setAttribute("name", name);
		session.setAttribute("hobby", hobby);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}
}
