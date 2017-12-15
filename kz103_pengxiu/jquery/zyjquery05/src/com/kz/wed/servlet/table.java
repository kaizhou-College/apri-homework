package com.kz.wed.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class table extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("{	" +
				"\"total\":12," +
				"\"rows\":" +
				"[{\"id\":\"1\",\"name\":\"a\",\"sex\":\"女\"}," +
				"{\"id\":\"2\",\"name\":\"b\",\"sex\":\"男\"}," +
				"{\"id\":\"3\",\"name\":\"c\",\"sex\":\"女\"}," +
				"{\"id\":\"4\",\"name\":\"d\",\"sex\":\"男\"}," +
				"{\"id\":\"5\",\"name\":\"e\",\"sex\":\"女\"}," +
				"{\"id\":\"6\",\"name\":\"f\",\"sex\":\"男\"}," +
				"{\"id\":\"7\",\"name\":\"g\",\"sex\":\"女\"}]}");
	}
}
