package work02;
/***
 * 3.��һ��jspҳ����,��request������������ֵ
 * ���û��������룬�Ͱ��ã����ã�ע���Ӧ��value�Ǹ��ַ������飩��
 * ,Ȼ��ת����һ��Servlet(�̳�GenericServlet)����,�ó��������Ͳ���ֵ��
 * ��������ͻ��ˣ�ʹ�ñ��
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servletwork03 extends GenericServlet {
	public Servletwork03() {
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
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) res;
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			String user = request.getParameter("user");
			String pswd = request.getParameter("pswd");
			out.print(user);
			out.print(pswd);
			String [] hp = request.getParameterValues("hoppy");
			for (String str : hp) {
				out.print(str+"");
			}
			
	}

}
