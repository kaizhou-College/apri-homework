package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("����get");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("����get����ajax����Ӧ");
		System.out.println();
		String a=request.getParameter("name");
		response.getWriter().write(a);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("����post");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("����post����ajax����Ӧ");
		System.out.println();
		String a=request.getParameter("name");
		String b=request.getParameter("age");
		response.getWriter().write(a);
		response.getWriter().write(b);
	}


}
