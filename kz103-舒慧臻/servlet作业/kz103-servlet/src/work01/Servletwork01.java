package work01;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/***
 * 写一个类实现Servlet接口，然后向客户端输出一段歌词的信息
 * ，要输出时解决中文乱码问题。
 * @author Administrator
 *
 */

public class Servletwork01 implements Servlet {
	public Servletwork01() {
		super();
	}
	public void destroy() {
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	}
	public void init() throws ServletException {
	}
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}
	@Override
	public String getServletInfo() {
		return null;
	}
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		
	}
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
			//向客户端输出
			System.out.println("servletwork01  在为客户端服务：这是一段歌词哟~");
			System.out.println("I was busy thinking 'bout boys");
			//解决中文乱码问题
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("servletwork01  在为客户端服务：这是一段歌词哟~");
			out.print("I was busy thinking 'bout boys");
			
	}

}
