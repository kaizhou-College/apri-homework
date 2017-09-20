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
		
		//��ȡweb.xml������
		//��ʽһ��req.getRealPath()
		//��ʽ����ServletContext
		ServletContext application = this.getServletContext();
		InputStream in = application.getResourceAsStream("/WEB-INF/index.html");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String content = br.readLine();
		while(content!=null){
			//��ͻ��˴�ӡ
			//out.print(content);
			System.out.println(content);
			//������
			content = br.readLine();
		}
		br.close();
		in.close();
		out.close();
	}

}
