package com.kqw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * @author 
 * 写一个jsp，三个文本框，分别填写姓名，住址，工作单位,以post方式提交到StrServlet(继承GenericServlet),在web-inf准备一个
 *str.properties文件
 * 文件内容: 二狗子 = **  (姓名)
 *           地狱 = ***    (住址)
 *          中央情报局=****  (工作单位)
 *
 */
public class StrServlet extends GenericServlet{

		//取文本框内容的值并打印
		public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
			PrintWriter out=res.getWriter();
			String name=req.getParameter("name");
			String name2=req.getParameter("name2");
			String name3=req.getParameter("name3");
			out.print("name===="+name+"||||"+"name2===="+name2+"||||"+"name3===="+name3);
		
	}

}
