package servletwork;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class servlet06 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		out.print("ÓÃ»§Ãû:"+req.getParameter("name"));
		String[] hobby = req.getParameterValues("hobby");
		for (int i = 0; i < hobby.length; i++) {
			out.print(hobby[i]);
		}
	}
}
