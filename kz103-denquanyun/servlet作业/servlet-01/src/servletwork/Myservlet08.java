package servletwork;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*8.写一个类继承GenericServlet,测试servlet的生命周期*/
public class Myservlet08 extends GenericServlet{
	public Myservlet08(){
		System.out.println("servlet出生了");
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("servlet销毁了");
	}
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("servlet培训了");
	}
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("servlet服务了");
	}
}
