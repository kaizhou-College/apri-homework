package work01;
/**
 * 写一个类继承GenericServlet,测试servlet的生命周期
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servletwork08 extends GenericServlet {
	private ServletConfig servletConfig;
	public Servletwork08() {
		System.out.println("创建Servletwork08");
	}
	public void destroy() {
		System.out.println("销毁Servletwork08");
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	@Override
	public ServletConfig getServletConfig() {
		return this.servletConfig;
	}
	
	public String getServletInfo() {
		return "我是servletwork02  我是测试servlet的声明周期的";
	}
	public void init(ServletConfig config) throws ServletException {
		System.out.println("初始化开始");
		this.servletConfig = config;
		
	}
	public void init() throws ServletException {
		super.init();
	}
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
			//服务的方法
			System.out.println("开启服务……");
		
	}

}
