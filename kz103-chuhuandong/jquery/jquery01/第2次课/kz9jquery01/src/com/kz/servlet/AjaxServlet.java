package com.kz.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("����AjaxServlet.......");
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write("���Ƿ���ajax����Ӧ");
	}
}
