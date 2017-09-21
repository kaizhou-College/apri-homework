package work02;
/***
 * 5.写一个servlet(继承GenericServlet)
 * 在配置文件中配置三个初始化值，然后在公共配置信息中也配置三个初始化值，
 * 然后在service方法中拿出值，打印输出到客户端
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servletwork05 extends GenericServlet {
	public Servletwork05() {
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
			res.setContentType("text/html;charset=utf-8");
			req.setCharacterEncoding("utf-8");
			PrintWriter out = res.getWriter();
			//单个信息
			ServletConfig config = getServletConfig();
			out.print("in-one"+config.getInitParameter("one"));
			out.print("<br>");
			out.print("in-two"+config.getInitParameter("two"));
			out.print("<br>");
			out.print("in-there"+config.getInitParameter("there"));
			out.print("<br>");
			//所有信息
			ServletContext application = this.getServletContext();
			out.print("out-one"+application.getInitParameter("one"));
			out.print("<br>");
			out.print("out-two"+application.getInitParameter("two"));
			out.print("<br>");
			out.print("out-there"+application.getInitParameter("there"));
			out.print("<br>");
	}

}
