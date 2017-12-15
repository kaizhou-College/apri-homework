package com.kz.svl;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoadServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("post请求");
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String uname = req.getParameter("uname");
		System.out.println("uname===="+uname);
		resp.getWriter().write("我是从servlet返回过来的数据");
		
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("get请求");
	}
}
