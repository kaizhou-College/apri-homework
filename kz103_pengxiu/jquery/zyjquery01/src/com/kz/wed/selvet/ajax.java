package com.kz.wed.selvet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ajax extends HttpServlet {
	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
//		System.out.println("进入了get提交方法");
		String value = request.getParameter("value");
		
//		System.out.println(value);
		String[] split = value.split(",");
		for (int i = 0; i < split.length; i++) {
			if(i%2==0){
				out.print("<p style='color:red'>参数"+(i+1)+":&nbsp;&nbsp;&nbsp;"+split[i]+"</p>");
			}else{
				out.print("<p>参数"+(i+1)+":&nbsp;&nbsp;&nbsp;"+split[i]+"</p>");
			}
		}
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String parameter = request.getParameter("value");
		String[] split = parameter.split(",");
		for (int i = 0; i < split.length; i++) {
			if(i%2==0){
				out.print("<p style='color:red'>参数"+(i+1)+":&nbsp;&nbsp;&nbsp;"+split[i]+"</p>");
			}else{
				out.print("<p>参数"+(i+1)+":&nbsp;&nbsp;&nbsp;"+split[i]+"</p>");
			}
		}
		out.flush();
		out.close();
	}
}
