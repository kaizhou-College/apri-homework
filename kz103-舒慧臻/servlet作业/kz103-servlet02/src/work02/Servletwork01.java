package work02;
/***
 * 1.写一个jsp，其中含有一个用户名的文本框和密码框，
 * 要求提交到一个servlet(继承HttpServlet)要求分别在doGet()
 * 和doPost()方法中解决中文乱码问题，然后将用户名和密码打印输出到客户端
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
			out.print("用户名："+name+"		密码"+pswd);
	}

	public void init() throws ServletException {
	}

}
