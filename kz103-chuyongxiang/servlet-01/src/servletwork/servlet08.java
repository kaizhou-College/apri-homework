package servletwork;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class servlet08 extends GenericServlet{
	public servlet08(){
		System.out.println("servlet������");
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("servlet������");
	}
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("��ʼservlet");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("��ʼservlet����");
	}

}
