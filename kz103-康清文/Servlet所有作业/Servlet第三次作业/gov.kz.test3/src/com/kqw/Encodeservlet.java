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
 * дһ���û�����¼��jsp��������д������û������ύ����¼��Encodeservlet��,дһ��filter����������
 *����������������⣨get/post������Ӧ�������������⣬Ȼ����servlet�еõ����ݣ�Ȼ���ӡ������ͻ���
 *
 */
public class Encodeservlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			String name=request.getParameter("name");
			int pwd=Integer.parseInt(request.getParameter("pwd"));
			out.print(name+"\t"+pwd);
			
	}

	
}
