package com.kqw;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.core.Config;

import org.omg.CORBA.Request;

import com.sun.net.httpserver.HttpServer;
/**
 * 
 * @author 
 * ��һ��jspҳ����ʹ��post��ʽ�ύһ���û���ţ�һ���û������Ͱ��õ�������ѡ�Servlet��
 * Servlet���պ���������⣬���������̨��(�̳�GenericServlet)
 */
public class Test4 extends GenericServlet{
	private ServletConfig ServletConfig;
	
	public ServletConfig getServletConfig() {
		return this.ServletConfig;
		
	}
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Myservlet02��ʼ����....");
		//����servlet����ĳ�ʼ��
		this.ServletConfig = config;
		
	}
	//����ķ���
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
			System.out.println("Test4��ʼ������");
			res.setContentType("text/html;charset=utf-8");
			ServletConfig config=getServletConfig();
			String hobby = config.getInitParameter("hobby");
			String hobbyy=config.getInitParameter("hobbyy");
			//��������
			//��ȡ�ύ��ʽ��request����
			HttpServletRequest request=(HttpServletRequest)req;
			String method = request.getMethod();
			//��ȡservlet�ı�������
			String encode=getServletConfig().getInitParameter("encode");
			//post�ύ����
			String name =null;
			String pwd = null;
			if(method.equalsIgnoreCase("post")){
				req.setCharacterEncoding(encode);
				name = req.getParameter("name");
				pwd = req.getParameter("pwd");
			}else{//get�ύ
				name = req.getParameter("name");
				name = new String(name.getBytes("iso-8859-1"),"utf-8");
				pwd = req.getParameter("pwd");
				pwd = new String(pwd.getBytes("iso-8859-1"),"utf-8");
			
			}
			
			System.out.println("name===="+name+"pwd===="+pwd);
			System.out.println("hobby==="+hobby+"---->"+"hobbyy===="+hobbyy);;
	}
	
		
	
	
}
