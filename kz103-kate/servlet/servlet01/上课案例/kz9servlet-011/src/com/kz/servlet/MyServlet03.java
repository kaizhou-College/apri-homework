package com.kz.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.HttpJspPage;
/**
 * servlet的编码问题
 * @author mr.chan
 *
 */
public class MyServlet03 implements Servlet {
	private ServletConfig config;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}
	//服务的方法
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//获取提交方式：request对象
		HttpServletRequest request = (HttpServletRequest) req;
		String method = request.getMethod();
		//获取servlet的编码配置
		String encode = config.getInitParameter("encode");
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
