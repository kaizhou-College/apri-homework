package com.kqw.Text;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Test4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//得到request里面的name
		String name=(String)request.getAttribute("name");
		//得到session里面的name
		HttpSession session = request.getSession();
		String sname = (String)session.getAttribute("name");
		//得到application里面的name
		ServletContext application = this.getServletContext();
		String aname = (String)application.getAttribute("name");
	
	 	System.out.println("request:"+name);
	 	System.out.println("session:"+sname);
	 	System.out.println("application:"+aname);
	 	out.print("request:    "+name+"\t");
	 	out.print("session:    "+sname+"\t");
	 	out.print("application:    "+aname+"\t");
	}

}
