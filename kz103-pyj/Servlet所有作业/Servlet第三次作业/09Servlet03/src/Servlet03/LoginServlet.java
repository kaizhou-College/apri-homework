package Servlet03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*��servlet�н��post��ʽ���������룬Ȼ���õ��û���,���û������õ�session�У�
Ȼ���ض���/save/save.jsp��*/
public class LoginServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String name=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		req.getSession().setAttribute("name", name);
		req.getSession().setAttribute("pwd", pwd);
		res.sendRedirect("save/save.jsp");
	}
}
