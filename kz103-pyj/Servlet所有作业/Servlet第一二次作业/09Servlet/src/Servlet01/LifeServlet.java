package Servlet01;
//2.дһ����ʵ��Servlet�ӿ�,����servlet����������
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LifeServlet implements Servlet{
	private ServletConfig servletConfig;
//���췽��
	public  LifeServlet(){
		System.out.println("LifeServlet������...");
	}
//����
	public void destroy() {
		System.out.println("LifeServlet������...");
	}
//�õ�����
	public ServletConfig getServletConfig() {
		return this.servletConfig;
	}
//�õ�servlet��Ϣ
	public String getServletInfo() {
		return "����LifeServlet������������LifeServlet����������...";
	}
//��ʼ��
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LifeServlet��ʼ��...");
		//���ж����ʼ��
		this.servletConfig=config;
	}
//����
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("LifeServlet��ʼ����...");
	}

}
