package work01;
/**
 * 
 *写一个类实现Servlet接口,测试servlet的生命周期
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servletwork02 implements Servlet {
	private ServletConfig servletConfig;

	public Servletwork02() {
		//出生即创建(向控制台输出)
		System.out.println("Servletwork02	被创建了");
	}

	public void destroy() {
		//死亡即被销毁
		System.out.println("Srevletwork02	被销毁了");
	}

	public void init() throws ServletException {
	}

	@Override
	public ServletConfig getServletConfig() {
		return this.servletConfig;
	}

	@Override
	public String getServletInfo() {
		return "我是servletwork02  我是测试servlet的声明周期的";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		//初始化servlet对象
		System.out.println("servlet初始化开始");
		this.servletConfig = config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
			//服务的方法
			System.out.println("开启服务……");
			ServletConfig config = getServletConfig();
			String hoppy = config.getInitParameter("hoppy");
			String encode = config.getInitParameter("encode");
			System.out.println("hoppy-----"+hoppy+"encode----"+encode);
	}

}
