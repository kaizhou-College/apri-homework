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
 * дһ����ʵ��Servlet�ӿڣ�Ȼ����ͻ������һ�θ�ʵ���Ϣ
 * ��Ҫ���ʱ��������������⡣
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
			//��ͻ������
			System.out.println("servletwork01  ��Ϊ�ͻ��˷�������һ�θ��Ӵ~");
			System.out.println("I was busy thinking 'bout boys");
			//���������������
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("servletwork01  ��Ϊ�ͻ��˷�������һ�θ��Ӵ~");
			out.print("I was busy thinking 'bout boys");
			
	}

}
