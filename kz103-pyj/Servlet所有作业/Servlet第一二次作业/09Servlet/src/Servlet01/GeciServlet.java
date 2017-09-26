package Servlet01;
/*
 * 1.写一个类实现Servlet接口，然后向客户端输出一段歌词的信息，要输出时解决中文乱码问题。
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GeciServlet implements Servlet{
//销毁
	public void destroy() {
		
	}
//得到配置
	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null;
	}
//初始化
	public void init(ServletConfig arg0) throws ServletException {
		
	}
//服务
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//向客户端输出
		System.out.println("在为客户端服务....");
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out=res.getWriter();
			out.print("GeciServlet01在为客户端服务....");
			out.print("<br>");
			out.print("《whitle lie》:");
			out.print("By the way we touch,There's lot of things That are dangerous");
	}
}
