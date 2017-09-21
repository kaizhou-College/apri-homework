package servletWork;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/*
 * 7.写一个servlet（继承GenericServlet),从请求中的头信息中找到主机地址的信息，然后打印到客户端
 * */
public class Myservlet07 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		StringBuffer header = request.getRequestURL();
		System.out.println(header);
	}

}
