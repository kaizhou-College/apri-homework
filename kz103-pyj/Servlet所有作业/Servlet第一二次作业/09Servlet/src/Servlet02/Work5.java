package Servlet02;
/*дһ��servlet(�̳�GenericServlet)�������ļ�������������ʼ��ֵ��Ȼ���ڹ���������Ϣ��Ҳ����������ʼ��ֵ��Ȼ����
service�������ó�ֵ����ӡ������ͻ���*/
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Work5 extends GenericServlet{
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		//�鵥����Ϣ
		ServletConfig config = getServletConfig();
		out.print("in-encode"+config.getInitParameter("in-encode"));
		out.print("<br>");
		out.print("in-age"+config.getInitParameter("in-age"));
		out.print("<br>");
		out.print("in-sex"+config.getInitParameter("in-sex"));
		out.print("<br>");
		//��������Ϣ
		ServletContext application = this.getServletContext();
		out.print("out-eid"+application.getInitParameter("out-eid"));
		out.print("<br>");
		out.print("out-ename"+application.getInitParameter("out-ename"));
		out.print("<br>");
		out.print("out-esex"+application.getInitParameter("out-esex"));
	}

}
