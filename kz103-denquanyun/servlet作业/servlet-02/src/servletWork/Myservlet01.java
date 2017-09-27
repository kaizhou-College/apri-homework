package servletWork;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 1.дһ��jsp�����к���һ���û������ı���������Ҫ���ύ��һ��servlet(�̳�HttpServlet)
  Ҫ��ֱ���doGet()��doPost()�����н�������������⣬Ȼ���û����������ӡ������ͻ���
 * */
public class Myservlet01 extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Enumeration pname = request.getParameterNames();
		while(pname.hasMoreElements()){
			String key =(String) pname.nextElement();
			String[] value=request.getParameterValues(key);
			for (int i = 0; i < value.length; i++) {
				value[i]=new String(value[i].getBytes("iso-8859-1"),"utf-8");
				
			}
			
		}
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
	}

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

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String name =request.getParameter("name");
		String pwd =request.getParameter("pwd");
		out.print(name+"----"+pwd);
	}

}
