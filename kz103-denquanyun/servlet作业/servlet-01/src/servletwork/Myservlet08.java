package servletwork;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*8.дһ����̳�GenericServlet,����servlet����������*/
public class Myservlet08 extends GenericServlet{
	public Myservlet08(){
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
		System.out.println("servlet��ѵ��");
	}
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("servlet������");
	}
}
