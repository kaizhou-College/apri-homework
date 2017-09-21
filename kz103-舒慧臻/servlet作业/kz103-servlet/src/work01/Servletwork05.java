package work01;
/**
 * 写一个jsp,jsp中一个用户登录的表单，有用户名和密码，
 * 以post方式提交到一个servlet(要求使用继承HttpServlet的方式完成)
 * 的 doPost()方法中，拿到数据，输出到控制台，然后以表格的形式，再输出到客户端
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
			//post提交
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
