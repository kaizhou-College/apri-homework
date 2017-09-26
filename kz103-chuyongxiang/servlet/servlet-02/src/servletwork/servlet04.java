package servletwork;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class servlet04 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		String a1=req.getParameter("a1");
		HttpSession session = req.getSession();
		String a2=req.getParameter("a2");
		String two = (String) session.getAttribute("a2");
		ServletContext application = this.getServletConfig().getServletContext();
		String three = (String) application.getAttribute("a3");
		out.print(a1);
		out.print(two);
		out.print(three);
	}
}
