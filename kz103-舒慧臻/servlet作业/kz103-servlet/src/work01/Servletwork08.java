package work01;
/**
 * дһ����̳�GenericServlet,����servlet����������
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
		System.out.println("����Servletwork08");
	}
	public void destroy() {
		System.out.println("����Servletwork08");
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
		return "����servletwork02  ���ǲ���servlet���������ڵ�";
	}
	public void init(ServletConfig config) throws ServletException {
		System.out.println("��ʼ����ʼ");
		this.servletConfig = config;
		
	}
	public void init() throws ServletException {
		super.init();
	}
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
			//����ķ���
			System.out.println("�������񡭡�");
		
	}

}
