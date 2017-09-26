package work01;
/**
 * 3.写一个类实现Servlet接口,统计此servlet被请求了多少次，
 * 输出到客户端,在销毁此Servlet的时候，将请求次数写到
 *硬盘的文本文档中.
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.jsp.jstl.core.Config;

public class Servletwork03 implements Servlet {
	private ServletConfig servletConfig;
	public Servletwork03() {
		System.out.println("servletwork被创建了");
	}
	public void destroy() {
		//销毁
		System.out.println("Servletwork03	被销毁了");
		
	}
	public void init() throws ServletException {
		
	}
	@Override
	public ServletConfig getServletConfig() {
		return this.getServletConfig();
	}
	@Override
	public String getServletInfo() {
		return "测试servletwork03	的声明周期的方法";
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("初始化开始");
		this.servletConfig = config;
	}
	int i = 0;
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			i=i+1;
			out.print("服务一次"+i+"次");
			
	}

}
