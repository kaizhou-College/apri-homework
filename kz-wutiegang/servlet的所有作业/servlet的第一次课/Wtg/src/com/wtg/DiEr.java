package com.wtg;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DiEr implements Servlet{
	private ServletConfig servletConfig;
/**
 * servlet���������ڣ���ʲôʱ�򴴽���ʲôʱ�����٣�
 * ���췽��  �����ķ���
 * destroy���� ���ٵķ���
 * init()����    ��ʼ���ķ���ֻ����һ��
 * service����ķ���      ������ٴξ͵��ö��ٴ�
 */
	//���췽��
	public DiEr(){
		System.out.println("DiEr��������");
	}
	//���ٵķ���
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("DiEr��������");
	}
	//�õ�servlet��������Ϣ
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.servletConfig;
	}
	//�õ�servlet����Ϣ
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "servlet����Ϣ";
	}
	//��ʼ��
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("DiEr��ʼ����");
		this.servletConfig=config;
	}
	//���񷽷�
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("������");
		ServletConfig Config = getServletConfig();
		String age=Config.getInitParameter("age");
		String encode=Config.getInitParameter("encode");
		System.out.println(age+encode);
	}

}
