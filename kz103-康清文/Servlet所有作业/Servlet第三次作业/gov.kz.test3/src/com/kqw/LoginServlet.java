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
 * ,��servlet�н��post��ʽ���������룬Ȼ���õ��û���,���û������õ�session�У�
 *Ȼ���ض���/save/save.jsp��,׼��һ�������������˵���/save/save.jsp����������doFilter()�м��session�����ֵ�Ƿ�Ϊ�գ�
 * ���Ϊ�գ��ض��򵽵�¼ҳ�档ע��:filter���á�
 *
 */
public class LoginServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
			String name=req.getParameter("name");
			String pwd=req.getParameter("pwd");
			//1,Ҫ���û���������---session
			req.getSession().setAttribute("name",name);
			//2������Admin.jspҳ�� �������Ҫ���ض��� 
			res.sendRedirect("save/save.jsp");
	}
}
