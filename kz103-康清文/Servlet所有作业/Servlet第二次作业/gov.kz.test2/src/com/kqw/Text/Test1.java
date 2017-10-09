package com.kqw.Text;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test1 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String wb=request.getParameter("wb");
		wb=new String(wb.getBytes("iso-8859-1"),"utf-8");
		String temp=request.getParameter("psw");
		int psw=Integer.parseInt(temp);
		out.print(wb+"\t"+psw);
	}

}
