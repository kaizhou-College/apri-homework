package com.accp.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 读取web-inf下面的资源
 * @author Administrator
 *
 */
public class MyServlet6 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		//获取application对象
		ServletContext context = this.getServletContext();
		
		//字节输入流
		//通过ServletContext读取一个web-inf下面的资源，转成字节输入流
		InputStream is =  context.getResourceAsStream("/WEB-INF/a.html");
		//缓冲输入流
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		//开始读数据
		String str = br.readLine();//读一行
		
		//设置响应方式
		res.setContentType("text/html;charset=utf-8");
		//获取响应输出流
		PrintWriter out = res.getWriter();
		while(str!=null){//如果读到了内容
			//响应出去
			out.print(str);
			str = br.readLine();//继续读取下一行数据
		}
		
		out.close();
		br.close();
		is.close();
		
		
		
	}

	
}
