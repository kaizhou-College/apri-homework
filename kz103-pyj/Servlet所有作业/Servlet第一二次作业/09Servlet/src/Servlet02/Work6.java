package Servlet02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Work6 extends GenericServlet{
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		//req.setCharacterEncoding("utf-8");
		//res.setContentType("text/html;charset=utf-8");
		HttpServletRequest request= (HttpServletRequest) req;
		HttpServletResponse response= (HttpServletResponse) res;
		String name=null;
		String aihao=null;
		String method=request.getMethod();
		if(method.equalsIgnoreCase("post")){
			req.setCharacterEncoding("utf-8");
			 name=req.getParameter("name");
			 aihao=req.getParameter("aihao");
		}
		out.print(name);
		out.print(aihao);
	}

}
