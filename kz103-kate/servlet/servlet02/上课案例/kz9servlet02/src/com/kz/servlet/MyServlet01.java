package com.kz.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 编码问题的第2版
 */
public class MyServlet01  extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//1,强制转换
		HttpServletRequest request= (HttpServletRequest) req;
		HttpServletResponse response= (HttpServletResponse) res;
		//2，获取请求方式
		String uname = null;
		String upwd = null;
		String method = request.getMethod();
		//3,解决编码
		if(method.equalsIgnoreCase("post")){
			req.setCharacterEncoding("utf-8");
			uname = req.getParameter("uname");
			upwd = req.getParameter("pwd");
		}else{
			//枚举---map类似(0731---长沙)
			Enumeration enumeration = request.getParameterNames();
			//resultSet  
			while(enumeration.hasMoreElements()){
				String key   = (String) enumeration.nextElement();
				String[] values = request.getParameterValues(key);
				for(int i=0;i<values.length;i++){
					values[i] = new String(values[i].getBytes("iso-8859-1"),"utf-8");
				}
			}
		}
		
		//4，获取值
		uname = request.getParameter("uname");
		System.out.println("uname=-"+uname);
		String sex = request.getParameter("sex");
		System.out.println("sex=-"+sex);
		
	}

}
