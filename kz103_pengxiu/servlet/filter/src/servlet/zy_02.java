package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class zy_02 extends GenericServlet{
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		out.print("name ==="+name);
		out.print("    pwd=="+pwd);
		
		
		
		
		
		
		
		
	}

}
