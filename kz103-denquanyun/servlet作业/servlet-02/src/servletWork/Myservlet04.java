package servletWork;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * 4.��һ��jspҳ����,�ֱ���request��session��application��ֵ��Ȼ��ת����һ��servlet�У��ó��������Ͳ���ֵ����ӡ��
  �ͻ���
 * */
public class Myservlet04 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("UTF-8");
		String one = (String) req.getAttribute("bitch3");
		HttpSession session = req.getSession();
		String two = (String) session.getAttribute("bitch1");
		ServletContext application = this.getServletConfig().getServletContext();
		String three = (String) application.getAttribute("bitch2");
		out.print(one);
		out.print("<br/>");
		out.print(two);
		out.print("<br/>");
		out.print(three);
		out.print("<br/>");
	}
}
