package work01;
/**
 * 
 *дһ����ʵ��Servlet�ӿ�,����servlet����������
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
		//����������(�����̨���)
		System.out.println("Servletwork02	��������");
	}

	public void destroy() {
		//������������
		System.out.println("Srevletwork02	��������");
	}

	public void init() throws ServletException {
	}

	@Override
	public ServletConfig getServletConfig() {
		return this.servletConfig;
	}

	@Override
	public String getServletInfo() {
		return "����servletwork02  ���ǲ���servlet���������ڵ�";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		//��ʼ��servlet����
		System.out.println("servlet��ʼ����ʼ");
		this.servletConfig = config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
			//����ķ���
			System.out.println("�������񡭡�");
			ServletConfig config = getServletConfig();
			String hoppy = config.getInitParameter("hoppy");
			String encode = config.getInitParameter("encode");
			System.out.println("hoppy-----"+hoppy+"encode----"+encode);
	}

}
