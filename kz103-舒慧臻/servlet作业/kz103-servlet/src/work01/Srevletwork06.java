package work01;
/***
 * 6.��һ��jspҳ����ʹ��get��ʽ�ύ�����ı���һ�������б�
 * �����б����ǣ�+,-,*,/����Servlet��
 * Servlet������������Ӧ�ļ��㣬�õ������������ͻ���.
 * (Ҫ��ʹ�ü̳�HttpServlet�ķ�ʽ���)
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Srevletwork06 extends HttpServlet {
	public Srevletwork06() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charest=utf-8");
			request.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			if(request.getParameter("result").equals("+")){
				int values = Integer.parseInt(request.getParameter("one"))+Integer.parseInt(request.getParameter("two"));
				out.print(values);
			}
			if(request.getParameter("result").equals("-")){
				int values = Integer.parseInt(request.getParameter("one"))-Integer.parseInt(request.getParameter("two"));
				out.print(values);
			}
			if(request.getParameter("result").equals("*")){
				int values = Integer.parseInt(request.getParameter("one"))*Integer.parseInt(request.getParameter("two"));
				out.print(values);
			}
			if(request.getParameter("result").equals("/")){
				int values = Integer.parseInt(request.getParameter("one"))/Integer.parseInt(request.getParameter("two"));
				out.print(values);
			}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	public void init() throws ServletException {
	}

}
