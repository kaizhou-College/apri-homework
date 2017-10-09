package work03.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StrServlet extends GenericServlet {
	public void init() throws ServletException {
	}
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
			PrintWriter out = res.getWriter();
			String name = req.getParameter("name");
//			String name1 = (name.substring(3).concat("**"));
			out.print("姓名="+name+"<br/>");
			String address = req.getParameter("address");
//			String address1 = (address.substring(2).concat("**"));
			out.print("住址="+address+"<br/>");
			String work = req.getParameter("work");
//			String work1 = (work.substring(5).concat("**"));
			out.print("工作单位="+work+"<br/>");
	}

}
