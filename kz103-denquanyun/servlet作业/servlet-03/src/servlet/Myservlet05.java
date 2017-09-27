package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Myservlet05 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = res.getWriter();
		String name= req.getParameter("name");
		String address= req.getParameter("address");
		String workunit = req.getParameter("workunit");
		out.print("用户名："+name);
		out.print("<br/>");
		out.print("地址"+address);
		out.print("<br/>");
		out.print("工作单位"+workunit);
	}

}
