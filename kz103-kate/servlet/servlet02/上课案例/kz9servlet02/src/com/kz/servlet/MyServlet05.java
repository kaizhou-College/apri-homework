package com.kz.servlet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet05 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		//读取web.xml的内容
		//方式一：req.getRealPath()
		//方式二：ServletContext
		ServletContext application = this.getServletContext();
		InputStream in = application.getResourceAsStream("/WEB-INF/index.html");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String content = br.readLine();
		while(content!=null){
			//向客户端打印
			//out.print(content);
			System.out.println(content);
			//继续读
			content = br.readLine();
		}
		br.close();
		in.close();
		out.close();
	}

}
