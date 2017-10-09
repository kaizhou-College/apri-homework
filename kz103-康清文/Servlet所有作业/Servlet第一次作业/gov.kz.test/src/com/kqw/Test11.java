package com.kqw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
/**
 * 
 * @author 
 * 从一个jsp页面上使用get方式提交两个文本框，一个下拉列表，下拉列表中是（+,-,*,/）到Servlet，
  Servlet根据请求做相应的计算，得到结果后输出到客户端.(要求使用继承HttpServlet的方式完成)

 */
public class Test11 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("开始服务");
		HttpServletRequest request=(HttpServletRequest)req;
		String method=request.getMethod();
		String encode=getServletConfig().getInitParameter("encode");
		int jia=0;
		int jian=0;
		int cheng=0;
		int chu=0;
		
		if(method.equalsIgnoreCase("POST")){
			req.setCharacterEncoding(encode);
			String temp1=request.getParameter("test1");
			int wenben1=Integer.parseInt(temp1);
			String temp2=request.getParameter("test2");
			int wenben2=Integer.parseInt(temp2);
			String m=request.getParameter("m");
			
			if(m.equals("+")){
				jia=wenben1+wenben2;
				
			}else if(m.equals("-")){
				jian=wenben1-wenben2;
				
			}else if(m.equals("*")){
				cheng=wenben1*wenben2;
				
			}else{
				chu=wenben1/wenben2;
				
			}
			
		}
		res.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = res.getWriter();
		out.print(jia+"=="+jian+"=="+cheng+"=="+chu);
	}

	

}

