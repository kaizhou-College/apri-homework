package com.kz.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyServlet04 extends GenericServlet {
	//如果我们要使用init()方法 推荐要重写无参数的init
	/*@Override
	public void init() throws ServletException {
		super.init();
	}*/
	//服务的方法
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("开始服务.....");
		//编码问题
		//获取提交方式：request对象
		HttpServletRequest request = (HttpServletRequest) req;
		String method = request.getMethod();
		//获取servlet的编码配置
		String encode = getServletConfig().getInitParameter("encode");
		//post提交编码
		String uname =null;
		String upwd = null;
		if(method.equalsIgnoreCase("post")){
			req.setCharacterEncoding(encode);
			uname = req.getParameter("uname");
			upwd = req.getParameter("pwd");
		}else{//get提交
			uname = req.getParameter("uname");
			uname = new String(uname.getBytes("iso-8859-1"),"utf-8");
			upwd = req.getParameter("pwd");
			//密码也要修改编码--省略
		}
		System.out.println("uname=="+uname+"---\tupwd=="+upwd);
	}

}
