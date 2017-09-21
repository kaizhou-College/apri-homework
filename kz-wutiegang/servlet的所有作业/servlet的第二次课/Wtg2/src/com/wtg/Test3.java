package com.wtg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Test3 extends GenericServlet {


	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		String method = request.getMethod();
		String uname=null;
		String psw=null;
		String[] aihao=null;
		if("post".equalsIgnoreCase(method)){
			req.setCharacterEncoding("utf-8");
			uname=req.getParameter("uname");
			psw=req.getParameter("psw");
			
			aihao=req.getParameterValues("aihao");
		}else{
			Enumeration enumeration = request.getParameterNames();
			while(enumeration.hasMoreElements()){
				String key=(String)enumeration.nextElement();
				String[] values = request.getParameterValues(key);
				for(int i=0;i<values.length;i++){
					values[i]=new String(values[i].getBytes("iso-8859-1"),"utf-8");
					
				}
			}
		}
		uname=request.getParameter("uname");
		psw=request.getParameter("psw");
		
		aihao=request.getParameterValues("aihao");
		
		out.print("<table border=1>");
		out.print("<tr>");
		out.print("<td>"+"uname用户名:"+"</td>");
		out.print("<td>"+uname+"</td>");
		out.print("<td>"+"psw密码:"+"</td>");
		out.print("<td>"+psw+"</td>");
		for (String string : aihao) {
			out.print("<td>"+"aihao爱好:"+"</td>");
			out.print("<td>"+string+"</td>");
		}
		
		out.print("</tr>");
		out.print("</table>");
	}

}
