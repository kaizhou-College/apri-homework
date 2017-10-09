package servletwork;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class servlet02 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html;charset=GBK");
		req.setCharacterEncoding("GBK");
		PrintWriter out=res.getWriter();
		HttpServletRequest request=(HttpServletRequest)req;		
        Enumeration enums=request.getHeaderNames();
	    while(enums.hasMoreElements()){
	    	String key = (String) enums.nextElement();
			String value = request.getHeader(key);
			out.print(key);
			out.print(value);
	    }
	}
}
