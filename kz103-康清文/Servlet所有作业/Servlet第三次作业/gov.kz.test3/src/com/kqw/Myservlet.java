package com.kqw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author 
 * дһ��jsp,��һ���������������û�����ѡ���Ա�ѡ�񰮺ö����ѡ�򣬸������ϵ��ı�����post�ύ��һ��Servlet��дһ��filter��������
 * �������е�ֵ�������Ϊnull���͸���һ�����ַ�����Ȼ����servlet�еõ����ݣ�Ҫ���������������,Ȼ���ӡ������ͻ���.
 */
public class Myservlet extends HttpServlet {

	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String uname=request.getParameter("uname");
		String sex=request.getParameter("sex");
		String like=request.getParameter("like");
		String info=request.getParameter("info");
		out.print(uname+"\t"+sex+"\t"+like+"\t"+info);
	}

}
