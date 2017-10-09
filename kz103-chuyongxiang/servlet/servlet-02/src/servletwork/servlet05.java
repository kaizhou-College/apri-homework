package servletwork;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class servlet05 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		ServletContext context = this.getServletContext();
		ServletConfig config = this.getServletConfig();
		Enumeration<String> ems = config.getInitParameterNames();
		while(ems.hasMoreElements()){
			String name = ems.nextElement();
			String value = config.getInitParameter(name);
			System.out.println(name+"---"+value);
		}
		System.out.println("----------------------");
		Enumeration<String> es = context.getInitParameterNames();
		while(es.hasMoreElements()){
			String name = es.nextElement();
			String value = context.getInitParameter(name);
			out.println(name+"---"+value);
		}
	}

}
