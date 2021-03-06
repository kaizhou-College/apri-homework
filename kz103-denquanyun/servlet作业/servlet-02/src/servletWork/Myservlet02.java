package servletWork;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/*
 * 2.写一个Servlet（）(继承GenericServlet),通过request得到请求头的信息,
 * 并将头信息以excel的形式输出给客户端
 * */
public class Myservlet02 extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("application/vnd.ms-excel;charset=utf-8");
		PrintWriter out = res.getWriter();
		HttpServletRequest request = (HttpServletRequest) req;
		Enumeration enumeration = request.getHeaderNames();
		while(enumeration.hasMoreElements()){
			String key = (String) enumeration.nextElement();
			String value = request.getHeader(key);
			out.print(key);
			out.print(value);
		}
	}

}
