package work02;
/***
 * 1.дһ��jsp�����к���һ���û������ı���������
 * Ҫ���ύ��һ��servlet(�̳�HttpServlet)Ҫ��ֱ���doGet()
 * ��doPost()�����н�������������⣬Ȼ���û����������ӡ������ͻ���
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servletwork01 extends HttpServlet {
	public Servletwork01() {
		super();
	}
	public void destroy() {
		super.destroy(); 
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			String name = request.getParameter("user");
			String pswd = request.getParameter("pswd");
			out.print("�û�����"+name+"		����"+pswd);
	}

	public void init() throws ServletException {
	}

}
