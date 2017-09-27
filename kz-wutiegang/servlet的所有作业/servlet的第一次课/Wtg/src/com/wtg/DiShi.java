package com.wtg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class DiShi extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("服务开始了");
		HttpServletRequest request=(HttpServletRequest)req;
		String method = request.getMethod();
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		if("post".equalsIgnoreCase(method)){
			req.setCharacterEncoding("utf-8");
			String temp1=request.getParameter("wenben1");
			int wenben1=Integer.parseInt(temp1);
			String temp2=request.getParameter("wenben2");
			int wenben2=Integer.parseInt(temp2);
			String temp3=request.getParameter("wenben3");
			int wenben3=Integer.parseInt(temp3);
			String xia=request.getParameter("xia");
			if("max".equalsIgnoreCase(xia)){
				int max=wenben1;
				if(wenben2>max){
					max=wenben2;
				}
				if(wenben3>max){
					max=wenben3;
				}
				out.print("最大值为："+max);
			}else{
				int min=wenben1;
				if(wenben2<min){
					min=wenben2;
				}
				if(wenben3<min){
					min=wenben3;
				}
				out.print("最小值为："+min);
			}
		}else{
			req.setCharacterEncoding("utf-8");
			String temp1=request.getParameter("wenben1");
			int wenben1=Integer.parseInt(temp1);
			String temp2=request.getParameter("wenben2");
			int wenben2=Integer.parseInt(temp2);
			String temp3=request.getParameter("wenben3");
			int wenben3=Integer.parseInt(temp3);
			String xia=request.getParameter("xia");
			if("max".equalsIgnoreCase(xia)){
				int max=wenben1;
				if(wenben2>max){
					max=wenben2;
				}
				if(wenben3>max){
					max=wenben3;
				}
				out.print("最大值为："+max);
			}else{
				int min=wenben1;
				if(wenben2<min){
					min=wenben2;
				}
				if(wenben3<min){
					min=wenben3;
				}
				out.print("最小值为："+min);
			}
		}
		
	}

}
