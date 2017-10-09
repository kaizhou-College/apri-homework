package com.wtg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test5 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletConfig config = getServletConfig();
		Enumeration<String> enumeration = config.getInitParameterNames();
		while(enumeration.hasMoreElements()){
			String key = enumeration.nextElement();
			String value=config.getInitParameter(key);
			//String[] values=request.getParameterValues(key);
			out.print(key+"\t"+value+"\t");
			/*for(int i=0;i<values.length;i++){
				out.print(values[i]+" ");
			}*/
		}
		ServletContext context = getServletContext();
		Enumeration<String> enumeration1 = context.getInitParameterNames();
		while(enumeration1.hasMoreElements()){
			String key = enumeration1.nextElement();
			String value=context.getInitParameter(key);
			//String[] values=request.getParameterValues(key);
			out.print(key+"\t"+value+"\t");
			/*for(int i=0;i<values.length;i++){
				out.print(values[i]+" ");
			}*/
		}
		
		
	}

}
