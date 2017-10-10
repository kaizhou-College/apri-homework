package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet04 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		String name=req.getParameter("name");
		String sex=req.getParameter("sex");
		String hobby=req.getParameter("hobby");
	}
}
