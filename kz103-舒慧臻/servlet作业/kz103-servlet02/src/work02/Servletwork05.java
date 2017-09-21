package work02;
/***
 * 5.дһ��servlet(�̳�GenericServlet)
 * �������ļ�������������ʼ��ֵ��Ȼ���ڹ���������Ϣ��Ҳ����������ʼ��ֵ��
 * Ȼ����service�������ó�ֵ����ӡ������ͻ���
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servletwork05 extends GenericServlet {
	public Servletwork05() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
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
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
			res.setContentType("text/html;charset=utf-8");
			req.setCharacterEncoding("utf-8");
			PrintWriter out = res.getWriter();
			//������Ϣ
			ServletConfig config = getServletConfig();
			out.print("in-one"+config.getInitParameter("one"));
			out.print("<br>");
			out.print("in-two"+config.getInitParameter("two"));
			out.print("<br>");
			out.print("in-there"+config.getInitParameter("there"));
			out.print("<br>");
			//������Ϣ
			ServletContext application = this.getServletContext();
			out.print("out-one"+application.getInitParameter("one"));
			out.print("<br>");
			out.print("out-two"+application.getInitParameter("two"));
			out.print("<br>");
			out.print("out-there"+application.getInitParameter("there"));
			out.print("<br>");
	}

}
