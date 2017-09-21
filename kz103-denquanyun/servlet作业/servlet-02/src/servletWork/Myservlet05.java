package servletWork;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * 5.写一个servlet(继承GenericServlet)在配置文件中配置三个初始化值，
 * 然后在公共配置信息中也配置三个初始化值，然后在service方法中拿出值，打印输出到客户端
 * */
public class Myservlet05 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		ServletConfig config = this.getServletConfig();
		ServletContext context = this.getServletContext();
		Enumeration enumeration= config.getInitParameterNames();
		while(enumeration.hasMoreElements()){
			String key = (String) enumeration.nextElement();
			String value = config.getInitParameter(key);
			out.print(key+"---"+value+"<br/>");
		}
		out.print("----------------------------<br/>");
		Enumeration enumeration2 = context.getInitParameterNames();
		while(enumeration2.hasMoreElements()){
			String key = (String) enumeration2.nextElement();
			String value = context.getInitParameter(key);
			out.print(key+"---"+value+"<br/>");
		}
	}

}
