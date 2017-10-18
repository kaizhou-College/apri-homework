package com.kz.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * servlet����������(ʲô������ ʲô����)
 * ���췽��		�����ķ���  ����һ��ҳֻ�����һ��
 * 	����ģʽ----һ����ֻ��newһ������
 * init()		��ʼ������  ����һ��
 * service() 	����ķ���  ���ٴ�����͵��ö��ٴ�
 * destroy()	���ٵķ���  
 * 
 * 
 */
public class MyServlet02 implements Servlet {
	private ServletConfig servletConfig;
	
	///���췽��
	public MyServlet02(){
		System.out.println("MyServlet02��������");
	}
	//���ٵķ���
	@Override
	public void destroy() {
		//��β���� -���� ���������
		System.out.println("MyServlet02��������");
	}
	//�õ�servlet������(���䣬��Χ....)
	
	@Override
	public ServletConfig getServletConfig() {
		return this.servletConfig;
	}
	//�õ�servlet����Ϣ
	@Override
	public String getServletInfo() {
		return "����myservlet02 ����������servetl����������";
	}
	//��ʼ��(��ѵ)
	/*��web����ȥ������ǰservlet������ʱ��
	 * ��servlet��������Ϣ��ȡ�����ҽ���Ϣ��װ��һ��
	 * ServletConfig��Ķ������ϣ�web�����ٽ��������
	 * ����init����������
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Myservlet02��ʼ����....");
		//����servlet����ĳ�ʼ��
		this.servletConfig = config;
		
	}
	//����ķ���
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("������");
		ServletConfig config = getServletConfig();
		String age = config.getInitParameter("age");
		String encode = config.getInitParameter("encode");
		System.out.println("age==="+age+"---->"+"encode===="+encode);;
	}

}
