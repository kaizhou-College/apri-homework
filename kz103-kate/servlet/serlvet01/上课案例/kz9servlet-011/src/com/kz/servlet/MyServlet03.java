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
 * servlet�ı�������
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
	//����ķ���
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//��ȡ�ύ��ʽ��request����
		HttpServletRequest request = (HttpServletRequest) req;
		String method = request.getMethod();
		//��ȡservlet�ı�������
		String encode = config.getInitParameter("encode");
		//post�ύ����
		String uname =null;
		String upwd = null;
		if(method.equalsIgnoreCase("post")){
			req.setCharacterEncoding(encode);
			uname = req.getParameter("uname");
			upwd = req.getParameter("pwd");
		}else{//get�ύ
			uname = req.getParameter("uname");
			uname = new String(uname.getBytes("iso-8859-1"),"utf-8");
			upwd = req.getParameter("pwd");
			//����ҲҪ�޸ı���--ʡ��
		}
		
		System.out.println("uname=="+uname+"---\tupwd=="+upwd);
	}

}
