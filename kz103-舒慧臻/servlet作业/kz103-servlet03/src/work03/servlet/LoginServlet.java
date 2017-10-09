package work03.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	public LoginServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			String user = request.getParameter("user");
			String pswd = request.getParameter("pswd");
			System.out.print("”√ªß√˚£∫"+user+"		"+"√‹¬Î£∫"+pswd);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("pswd", pswd);
			response.sendRedirect("save/save.jsp");
	}
	public void init() throws ServletException {
	}

}
