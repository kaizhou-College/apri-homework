package com.wtg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class Test7 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��reqǿ��ת����httpЭ��
		HttpServletRequest request=(HttpServletRequest)req;
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		//�õ�ͷ����������Ϣ
		Enumeration enumeration = request.getHeaderNames();
		//����ͷ������Ϣ�����������ַ
	StringBuffer requestURL = request.getRequestURL();
		out.print(requestURL);
		/*String requestURI = request.getRequestURI();
		out.print(requestURI);*/
		/*while(enumeration.hasMoreElements()){
			String key =(String) enumeration.nextElement();
			String[] values=request.getParameterValues(key);
			
		}*/
		
		
	}

}
