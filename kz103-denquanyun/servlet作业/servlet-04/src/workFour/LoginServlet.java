package workFour;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		UserInfo u = new UserInfo(name, pwd);
		request.getSession().setAttribute("user",u);
		response.sendRedirect("result.jsp");
	}

}
