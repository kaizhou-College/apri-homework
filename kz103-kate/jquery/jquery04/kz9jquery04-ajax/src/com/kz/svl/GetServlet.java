package com.kz.svl;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String uname = req.getParameter("uname");
		uname = new String(uname.getBytes("iso-8859-1"),"utf-8");
		System.out.println("uname==="+uname);
		resp.setContentType("text/plain;charset=utf-8");
		resp.getWriter().write("[{\"id\":\"1\",\"name\":\"二狗子\"},{\"id\":\"2\",\"name\":\"三狗子\"}]");
	}
}
