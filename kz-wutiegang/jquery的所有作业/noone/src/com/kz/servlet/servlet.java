package com.kz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import sun.org.mozilla.javascript.internal.json.JsonParser;

public class servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String parameter = req.getParameter("json");
		resp.getWriter().write(parameter);
		resp.getWriter().write("我是发给ajax的响应的get方法");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("进入AjaxServlet.......");
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String parameter = req.getParameter("json");
		
		System.err.println(parameter+"   aa  ");
		resp.getWriter().write(parameter);
		resp.getWriter().write("我是发给ajax的响应");
	}


}
