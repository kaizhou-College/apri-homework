package com.kqw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * @author 
 * дһ��jsp�������ı��򣬷ֱ���д������סַ��������λ,��post��ʽ�ύ��StrServlet(�̳�GenericServlet),��web-inf׼��һ��
 *str.properties�ļ�
 * �ļ�����: ������ = **  (����)
 *           ���� = ***    (סַ)
 *          �����鱨��=****  (������λ)
 *
 */
public class StrServlet extends GenericServlet{

		//ȡ�ı������ݵ�ֵ����ӡ
		public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
			PrintWriter out=res.getWriter();
			String name=req.getParameter("name");
			String name2=req.getParameter("name2");
			String name3=req.getParameter("name3");
			out.print("name===="+name+"||||"+"name2===="+name2+"||||"+"name3===="+name3);
		
	}

}
