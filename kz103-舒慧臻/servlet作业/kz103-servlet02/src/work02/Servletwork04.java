package work02;
/**
 * 4.��һ��jspҳ����,�ֱ���request��session��application��ֵ��
 * Ȼ��ת����һ��servlet�У��ó��������Ͳ���ֵ����ӡ���ͻ���
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servletwork04 extends HttpServlet {
	public Servletwork04() {
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
			request.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			Object human = request.getAttribute("human");
			
	}
	public void init() throws ServletException {
	}

}
