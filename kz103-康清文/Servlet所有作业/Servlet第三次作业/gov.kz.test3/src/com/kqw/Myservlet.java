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
 * 写一个jsp,有一个表单，可以输入用户名，选择性别，选择爱好多个复选框，个人资料的文本域，用post提交到一个Servlet，写一个filter过滤请求
 * 遍历所有的值，如果有为null，就给它一个空字符串，然后在servlet中得到数据，要解决中文乱码问题,然后打印输出到客户端.
 */
public class Myservlet extends HttpServlet {

	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String uname=request.getParameter("uname");
		String sex=request.getParameter("sex");
		String like=request.getParameter("like");
		String info=request.getParameter("info");
		out.print(uname+"\t"+sex+"\t"+like+"\t"+info);
	}

}
