package servletwork;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//1.дһ����ʵ��Servlet�ӿڣ�Ȼ����ͻ������һ�θ�ʵ���Ϣ��
//Ҫ���ʱ��������������⡣

public class Myservlet01  implements Servlet{

	public void destroy() {//����
		// TODO Auto-generated method stub
		
	}

	public ServletConfig getServletConfig() {//�õ�����
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	//��ʼ��
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	//����
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print("��������� ������   �ҸĻ����� ����ԭ    �������� û�˹�   ��һ��ֻ�� ������");
	}

}
