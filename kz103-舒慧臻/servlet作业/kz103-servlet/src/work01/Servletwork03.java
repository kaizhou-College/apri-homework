package work01;
/**
 * 3.дһ����ʵ��Servlet�ӿ�,ͳ�ƴ�servlet�������˶��ٴΣ�
 * ������ͻ���,�����ٴ�Servlet��ʱ�򣬽��������д��
 *Ӳ�̵��ı��ĵ���.
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
		System.out.println("servletwork��������");
	}
	public void destroy() {
		//����
		System.out.println("Servletwork03	��������");
		
	}
	public void init() throws ServletException {
		
	}
	@Override
	public ServletConfig getServletConfig() {
		return this.getServletConfig();
	}
	@Override
	public String getServletInfo() {
		return "����servletwork03	���������ڵķ���";
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("��ʼ����ʼ");
		this.servletConfig = config;
	}
	int i = 0;
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			i=i+1;
			out.print("����һ��"+i+"��");
			
	}

}
