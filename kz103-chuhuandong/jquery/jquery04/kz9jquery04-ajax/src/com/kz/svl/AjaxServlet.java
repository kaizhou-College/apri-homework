package com.kz.svl;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String uname = req.getParameter("uname");
		System.out.println("uname=="+uname);
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write("我是发送回去的内容！！！");
	}
}
