package Servlet01;
/*
 * 1.дһ����ʵ��Servlet�ӿڣ�Ȼ����ͻ������һ�θ�ʵ���Ϣ��Ҫ���ʱ��������������⡣
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GeciServlet implements Servlet{
//����
	public void destroy() {
		
	}
//�õ�����
	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null;
	}
//��ʼ��
	public void init(ServletConfig arg0) throws ServletException {
		
	}
//����
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//��ͻ������
		System.out.println("��Ϊ�ͻ��˷���....");
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out=res.getWriter();
			out.print("GeciServlet01��Ϊ�ͻ��˷���....");
			out.print("<br>");
			out.print("��whitle lie��:");
			out.print("By the way we touch,There's lot of things That are dangerous");
	}
}
