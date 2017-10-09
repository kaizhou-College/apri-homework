package com.kqw.Text;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test6 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String method = request.getMethod();
		String uname=null;
		String[] aihao=null;
		if("post".equalsIgnoreCase(method)){
			req.setCharacterEncoding("utf-8");
			uname=request.getParameter("uname");
			aihao=request.getParameterValues("aihao");
			
		}else{
			Enumeration enumeration = request.getParameterNames();
			while(enumeration.hasMoreElements()){
				String key = (String)enumeration.nextElement();
				String[] values=request.getParameterValues(key);
				for(int i=0;i<values.length;i++){
					values[i]=new String(values[i].getBytes("iso-8859-1"),"utf-8");
				}
			}
		}
		uname=request.getParameter("uname");
		aihao=request.getParameterValues("aihao");
		out.println(uname);
		
		for (String string : aihao) {
			out.print(string+" ");
		}
	}

}
