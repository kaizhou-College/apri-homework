package Servlet03;
//Ȼ����servlet�еõ����ݣ�Ҫ���������������,Ȼ���ӡ������ͻ���.
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Work4Servlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		String name=req.getParameter("name");
		String sex=req.getParameter("sex");
		String ziliao=req.getParameter("ziliao");
		String aihao=req.getParameter("aihao");
		out.print("name="+name);
		out.print("<br>");
		out.print("sex="+sex);
		out.print("<br>");
		out.print("ziliao="+ziliao);
		out.print("<br>");
		out.print("aihao="+aihao);
	}
}
