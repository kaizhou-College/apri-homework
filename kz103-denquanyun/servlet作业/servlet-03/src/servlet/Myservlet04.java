package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Myservlet04 extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			String[] hobby = request.getParameterValues("hobby");
			String myself = request.getParameter("myself");
			out.print(name);
			out.print(sex);
			out.print(myself);
			if(hobby!=null){
				for (int i = 0; i < hobby.length; i++) {
					out.print(hobby[i]);
				}
			}
	}

}
