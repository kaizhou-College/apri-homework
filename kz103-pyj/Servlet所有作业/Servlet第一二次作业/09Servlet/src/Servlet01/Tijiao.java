package Servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class Tijiao extends GenericServlet{
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("开始服务...");
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		//提交编码
		String  id = req.getParameter("id");
		String name=req.getParameter("name");
		String aihao=req.getParameter("aihao");
		out.print("<table border='1'>");
			out.print("<tr>");
				out.print("<td>"+id+"</td>");
				out.print("<td>"+name+"</td>");
				out.print("<td>"+aihao+"</td>");
			out.print("</tr>");
		out.print("</table>");
		System.out.println("id="+id+"\tname="+name+"\taihao="+aihao);
		
	}
}


