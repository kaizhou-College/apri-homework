package com.kz.serlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet04 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int num;
		int number1 = Integer.parseInt(request.getParameter("number1"));
		int number2 = Integer.parseInt(request.getParameter("number2"));
		String ysf = request.getParameter("ysf");
		ysf = new String(ysf.getBytes("iso-8859-1"),"utf-8");
		if(ysf.equals("+")){
			num=number1+number2;
		}else if(ysf.equals("-")){
			num=number1-number2;
		}else if(ysf.equals("*")){
			num=number1*number2;
		}else{
			num=number1/number2;
		}
		out.print(num);
	}
}
