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
 * ��һ��jspҳ����ʹ��get��ʽ�ύ�����ı���һ�������б������б����ǣ�+,-,*,/����Servlet��
  Servlet������������Ӧ�ļ��㣬�õ������������ͻ���.(Ҫ��ʹ�ü̳�HttpServlet�ķ�ʽ���)

 */
public class Test11 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("��ʼ����");
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

