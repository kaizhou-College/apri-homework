package com.kz.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyServlet04 extends GenericServlet {
	//�������Ҫʹ��init()���� �Ƽ�Ҫ��д�޲�����init
	/*@Override
	public void init() throws ServletException {
		super.init();
	}*/
	//����ķ���
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("��ʼ����.....");
		//��������
		//��ȡ�ύ��ʽ��request����
		HttpServletRequest request = (HttpServletRequest) req;
		String method = request.getMethod();
		//��ȡservlet�ı�������
		String encode = getServletConfig().getInitParameter("encode");
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
