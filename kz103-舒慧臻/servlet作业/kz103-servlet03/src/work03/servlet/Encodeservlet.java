package work03.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Encodeservlet extends HttpServlet {
	public Encodeservlet() {
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
			PrintWriter out = response.getWriter();
			String user = request.getParameter("user");
			String pswd = request.getParameter("pswd");
			out.print("”√ªß√˚£∫"+user+"		"+"√‹¬Î£∫"+pswd);
	}

	public void init() throws ServletException {
	}

}
