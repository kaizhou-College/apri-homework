package work01;
/***
 * 11.��һ��jspҳ��дһ����������һ���ı���
 * ���������û��ı�ţ��ύ��һ��servlet��
 * ���ݱ��ɾ������(Ҫ��ʹ�ü̳�HttpServlet�ķ�ʽ���)
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.userself;

public class Servletwork11 extends HttpServlet {
	public Servletwork11() {
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
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			userself user = new userself();
			
	}

	public void init() throws ServletException {
	}

}
