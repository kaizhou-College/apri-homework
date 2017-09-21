package com.wtg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class DiSY extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		res.setContentType("application/vnd.ms-excel;charset=utf-8");
		PrintWriter out = res.getWriter();
		Enumeration enumeration = req.getParameterNames();
		while(enumeration.hasMoreElements()){
			String key  = (String)enumeration.nextElement();
			String value = req.getParameter(key);
			
			req.removeAttribute(key);
			System.out.println(key);
			
		}
	}
}
