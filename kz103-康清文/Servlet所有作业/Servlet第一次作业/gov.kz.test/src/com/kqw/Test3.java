package com.kqw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * @author 
 * дһ����ʵ��Servlet�ӿ�,ͳ�ƴ�servlet�������˶��ٴΣ�������ͻ���,�����ٴ�Servlet��ʱ�򣬽��������д��
      Ӳ�̵��ı��ĵ���.
	
 */
public class Test3 implements Servlet{

	private ServletConfig ServletConfig;

	//���췽��
	public Test3(){
		System.out.println("Servlet������������");
		
	}
	
	//���ٵķ���
	public void destroy() {
		System.out.println("Servlet������������");
		
	}
	
	public ServletConfig getServletConfig() {
		return this.ServletConfig;
		
	}
	//�õ�servlet����Ϣ
	public String getServletInfo() {
		return "����Test3,��������Servlet����������";
		
	}

	//����servlet����ĳ�ʼ��
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Test3�������г�ʼ��");
		this.ServletConfig=config;
	}


	//����ķ���
	int i;
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
			System.out.println("Test3��ʼ������");
			ServletConfig config=getServletConfig();
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out=res.getWriter();
			i++;
			out.print("servlet��������"+i+"���ٴ�");
			
		
	}

}
