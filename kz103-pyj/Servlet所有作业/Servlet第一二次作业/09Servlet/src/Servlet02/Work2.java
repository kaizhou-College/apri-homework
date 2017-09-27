package Servlet02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*写一个Servlet（）(继承GenericServlet),通过request得到请求头的信息
,并将头信息以excel的形式输出给客户端*/

public class Work2 extends GenericServlet{
	public void service(ServletRequest req, ServletResponse rep)
			throws ServletException, IOException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse) rep;
		rep.setContentType("application/vnd.ms_excel;charset=utf-8");
		PrintWriter out = rep.getWriter();
		//请求头信息
		Enumeration enumeration = request.getHeaderNames();
		while(enumeration.hasMoreElements()){
			String key=(String)enumeration.nextElement();
			String value=request.getHeader(key);
			out.print(key);
			out.print(value);
		}
	}
}
