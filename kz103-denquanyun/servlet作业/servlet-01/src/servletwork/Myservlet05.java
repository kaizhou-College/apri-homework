package servletwork;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Myservlet05  extends HttpServlet{
/*
5.дһ��jsp,jsp��һ���û���¼�ı������û��������룬��post��ʽ�ύ��һ��servlet(Ҫ��ʹ�ü̳�HttpServlet�ķ�ʽ���)��
  doPost()�����У��õ����ݣ����������̨��Ȼ���Ա�����ʽ����������ͻ���
*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("������dopost()����");
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		PrintWriter out = resp.getWriter();
		out.print("<table border=1>");
				out.print("<tr>");
				out.print("<td>"+name+"</td>");
				out.print("</tr>");
				out.print("<tr>");
				out.print("<td>"+pwd+"</td>");
				out.print("</tr>");
		out.print("</table>");
	}
}
