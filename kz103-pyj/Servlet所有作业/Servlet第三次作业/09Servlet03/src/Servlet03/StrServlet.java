package Servlet03;
// 5.过滤之后，在StrServlet中拿到数据,打印输出到客户端
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StrServlet extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) res;
		PrintWriter out = response.getWriter();
		String name=request.getParameter("name");
		out.print("name="+name);
		out.print("<br>");
		String zhuzhi=request.getParameter("zhuzhi");
		out.print("zhuzhi="+zhuzhi);
		out.print("<br>");
		String gongz=request.getParameter("gongz");
		out.print("gongz="+gongz);
	}
	public void init() throws ServletException {
	}

}
