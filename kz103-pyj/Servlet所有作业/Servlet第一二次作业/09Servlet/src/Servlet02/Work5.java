package Servlet02;
/*写一个servlet(继承GenericServlet)在配置文件中配置三个初始化值，然后在公共配置信息中也配置三个初始化值，然后在
service方法中拿出值，打印输出到客户端*/
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Work5 extends GenericServlet{
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		//查单个信息
		ServletConfig config = getServletConfig();
		out.print("in-encode"+config.getInitParameter("in-encode"));
		out.print("<br>");
		out.print("in-age"+config.getInitParameter("in-age"));
		out.print("<br>");
		out.print("in-sex"+config.getInitParameter("in-sex"));
		out.print("<br>");
		//查所有信息
		ServletContext application = this.getServletContext();
		out.print("out-eid"+application.getInitParameter("out-eid"));
		out.print("<br>");
		out.print("out-ename"+application.getInitParameter("out-ename"));
		out.print("<br>");
		out.print("out-esex"+application.getInitParameter("out-esex"));
	}

}
