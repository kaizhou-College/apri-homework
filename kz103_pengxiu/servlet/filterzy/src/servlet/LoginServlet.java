package servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends GenericServlet{
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		System.out.println(user+"==user111  ");
		System.out.println(pwd+"==pwd1111");
		if(user.equals("admin")&&pwd.equals("admin")){
			response.sendRedirect("dync.jsp");
			
		}else{
			response.sendRedirect("error.jsp");
		}
	}
}
