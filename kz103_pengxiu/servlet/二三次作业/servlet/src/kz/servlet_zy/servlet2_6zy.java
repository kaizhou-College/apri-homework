package kz.servlet_zy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class servlet2_6zy extends GenericServlet {
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		PrintWriter out=response.getWriter();
		if("POST".equalsIgnoreCase(request.getMethod())){
			request.setCharacterEncoding("utf-8");
		}else{
			Enumeration names = request.getParameterNames();
			while(names.hasMoreElements()){
				String name=(String) names.nextElement();
				String[] values=request.getParameterValues(name);
				for (int i = 0; i < values.length; i++) {
					values[i]=new String(values[i].getBytes("iso-8859-1"),"utf-8");
				}
				
			}
		}
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		String[] values = request.getParameterValues("aihao");
		out.print("name==="+name);
		for (int i = 0; i < values.length; i++) {
			out.print("  aihao=="+values[i]);
		}
		
		
		
		
		
		
	}

	
}
