package com.wtg;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class DiSi extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("开始服务");
		HttpServletRequest request=(HttpServletRequest)req;
		String method=request.getMethod();
		String encode=getServletConfig().getInitParameter("encode");
		String bianhao=null;
		String name=null;
		String aihao=null;
		if(method.equalsIgnoreCase("post")){
			req.setCharacterEncoding(encode);
			bianhao=req.getParameter("bianhao");
			name=req.getParameter("name");
			aihao=req.getParameter("aihao");
			
		}
		
		System.out.println(bianhao+"\t"+name+"\t"+aihao);
	}

}
