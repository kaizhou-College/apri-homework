package work01;
/**
 * дһ��jsp,jsp��һ���û���¼�ı������û��������룬
 * ��post��ʽ�ύ��һ��servlet(Ҫ��ʹ�ü̳�HttpServlet�ķ�ʽ���)
 * �� doPost()�����У��õ����ݣ����������̨��Ȼ���Ա�����ʽ����������ͻ���
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servletwork05 extends HttpServlet {
	public Servletwork05() {
		super();
	}
	public void destroy() {
		super.destroy(); 
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			//post�ύ
			out.write("<table border='1' align='center'>");
				out.write("<tr>");
				String key = request.getParameter("uname");
				out.write("<td>"+key+"</td>");
				String value = request.getParameter("pswd");
				out.write("<td>"+value+"</td>");
				out.write("</tr>");
				out.write("</table>");
	}

	public void init() throws ServletException {
	}

}
