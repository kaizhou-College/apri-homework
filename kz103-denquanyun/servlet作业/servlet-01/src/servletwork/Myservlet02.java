package servletwork;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//2.дһ����ʵ��Servlet�ӿ�,����servlet����������

public class Myservlet02 implements Servlet{
	
	public Myservlet02(){//����
		System.out.println("servlet������");
	}
	public void destroy() {//������
		// TODO Auto-generated method stub
		System.out.println("servlet������");
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.getServletConfig();
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "����";
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("servlet��ѵ��");
	}

	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("servlet������");

	}

}
