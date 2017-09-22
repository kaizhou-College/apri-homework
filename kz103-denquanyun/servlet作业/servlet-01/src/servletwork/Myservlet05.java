package servletwork;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Myservlet05  extends HttpServlet{
/*
5.写一个jsp,jsp中一个用户登录的表单，有用户名和密码，以post方式提交到一个servlet(要求使用继承HttpServlet的方式完成)的
  doPost()方法中，拿到数据，输出到控制台，然后以表格的形式，再输出到客户端
*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("调用了dopost()方法");
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
