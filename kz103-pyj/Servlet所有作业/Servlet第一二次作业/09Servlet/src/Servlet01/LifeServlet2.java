package Servlet01;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LifeServlet2 extends GenericServlet{
	public void LifeServlet2(){
		System.out.println("LifeServlet2������...");
	}
	//����
	public void destroy() {
		System.out.println("LifeServlet2������...");
	}
//�õ�����
	public ServletConfig getServletConfig() {
		return null;
	}
//
	public String getServletInfo() {
		return null;
	}
//��ʼ��(��ѵ)
	public void init() throws ServletException {
		System.out.println("LifeServlet2��ʼ��...");
	}
	//����	
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("��ʼ����...");
		
	}

}
