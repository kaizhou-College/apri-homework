package Servlet03;
//2.Ȼ����servlet�еõ����ݣ�Ȼ���ӡ������ͻ���
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Encodeservlet extends HttpServlet {

protected void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
	PrintWriter out = res.getWriter();
	String name=req.getParameter("name");
	String pwd=req.getParameter("pwd");
	out.print("name="+name);
	out.print("<br>");
	out.print("pwd="+pwd);
}

}
