package com.kqw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author 
 * 写一个用户名登录的jsp，可以填写密码和用户名，提交到登录的Encodeservlet中,写一个filter过滤请求解决
 *请求的中文乱码问题（get/post）和响应的中文乱码问题，然后在servlet中得到数据，然后打印输出到客户端
 *
 */
public class Encodeservlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			String name=request.getParameter("name");
			int pwd=Integer.parseInt(request.getParameter("pwd"));
			out.print(name+"\t"+pwd);
			
	}

	
}
