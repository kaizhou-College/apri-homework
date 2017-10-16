package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class haha extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;setchar=utf-8");
		PrintWriter out = response.getWriter();
		List list=new ArrayList();
		list.add("a");
		list.add("a");
		list.add("a");
		request.setAttribute("list",list);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


}
