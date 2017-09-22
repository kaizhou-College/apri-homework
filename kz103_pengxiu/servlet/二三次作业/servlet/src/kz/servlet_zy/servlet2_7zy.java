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

public class servlet2_7zy extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		response.setContentType("text/xecel;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		HttpServletRequest req = (HttpServletRequest)request;
		
		Enumeration<String> ems =  request.getHeaderNames();
		while(ems.hasMoreElements()){
			String name = ems.nextElement();
			String value  = (String)req.getHeader(name);
			if(name.equals("host")){
			out.println(name+" : "+value+"<br/>");
			}
		}
		out.flush();
		out.close();
	}

}
