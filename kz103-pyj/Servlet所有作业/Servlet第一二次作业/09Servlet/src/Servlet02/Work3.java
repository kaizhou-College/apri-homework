package Servlet02;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Work3 extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		PrintWriter out = res.getWriter();
		String name=null;
		String pwd=null;
		String aihao=null;
		String method=request.getMethod();
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		if(method.equals("post")){
			name=request.getParameter("name");
			pwd=request.getParameter("pwd");
			aihao=request.getParameter("aihao");
			//name=req.getParameter("name");
			//pwd=req.getParameter("pwd");
			//aihao=req.getParameter("aihao");
		}else{
			Enumeration enumeration = request.getParameterNames();
			while(enumeration.hasMoreElements()){
				String key=(String)enumeration.nextElement();
				String[] values=request.getParameterValues(key);
				for (int i = 0; i < values.length; i++) {
					values[i]=new String (values[i].getBytes("iso-8859-1"),"utf-8");
				}
			}
			name=request.getParameter("name");
			pwd=req.getParameter("pwd");
			aihao=req.getParameter("aihao");
			out.print(name);
			out.print(pwd);
			out.print(aihao);
		}
	}
}
