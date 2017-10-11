package com.kqw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 *写一个jsp,jsp中一个用户登录的表单，有用户名和密码，以post方式提交到一个servlet(要求使用继承HttpServlet的方式完成)的
 *doPost()方法中，拿到数据，输出到控制台，然后以表格的形式，再输出到客户端
 *
 *(待完善)
 */
public class Test5 extends HttpServlet {

		
		protected void service(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
				doPost(req, resp);
				resp.setContentType("text/html;charset=utf-8");
				ServletConfig config=getServletConfig();
				//编码问题
				//获取提交方式：request对象
				HttpServletRequest request=(HttpServletRequest)req;
				String method = request.getMethod();
				//获取servlet的编码配置
				String encode=getServletConfig().getInitParameter("encode");
				//post提交编码
				String name =null;
				String pwd = null;
				if(method.equalsIgnoreCase("post")){
					req.setCharacterEncoding(encode);
					name = req.getParameter("name");
					pwd = req.getParameter("pwd");
				}else{//get提交
					name = req.getParameter("name");
					name = new String(name.getBytes("iso-8859-1"),"utf-8");
					pwd = req.getParameter("pwd");
					pwd = new String(pwd.getBytes("iso-8859-1"),"utf-8");
				
				}
				
				System.out.println("name===="+name+"pwd===="+pwd);
				
		}
	

}
