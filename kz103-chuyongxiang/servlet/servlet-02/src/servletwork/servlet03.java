package servletwork;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class servlet03 extends  GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = res.getWriter();
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String aihao = req.getParameter("aihao");
		out.println(name);
		out.println(pwd);
		out.println(aihao);
	}
}
