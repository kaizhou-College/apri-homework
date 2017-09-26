package kz.servlet_zy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class servlet2_5zy extends GenericServlet {
	private ServletConfig config;
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config=config;
		
	}
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		PrintWriter out=arg1.getWriter();
		// TODO Auto-generated method stub
		//配置文件中配置三个初始化值
		String encode3=config.getInitParameter("encode3");
		out.print(encode3+"   ");
		String encode4=config.getInitParameter("encode4");
		out.print(encode4+"   ");
		String encode5=config.getInitParameter("encode5");
		out.print(encode5+"   ");
		//配置文件外配置三个初始化值
		String encode=config.getServletContext().getInitParameter("encode");
		out.print(encode+"   ");
		String encode1=config.getServletContext().getInitParameter("encode1");
		out.print(encode1+"   ");
		String encode2=config.getServletContext().getInitParameter("encode2");
		out.print(encode2+"   ");
	}

}




























