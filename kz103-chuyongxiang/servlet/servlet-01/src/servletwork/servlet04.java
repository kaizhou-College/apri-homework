package servletwork;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class servlet04 implements Servlet{
	private ServletConfig config;
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config=config;
	}

	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest) req;
		String method=request.getMethod();
		String encode = config.getInitParameter("encode");
		String id=null;
		String uname=null;
		String aihao=null;
		if(method.equalsIgnoreCase("post")){
			req.setCharacterEncoding(encode);
			id=req.getParameter("id");
			uname=req.getParameter("name");
			aihao=req.getParameter("aihao");
		}else{
			id=req.getParameter("id");
			id=new String(id.getBytes("iso-8859-1"),"utf-8");
			uname=req.getParameter("name");
			id=new String(uname.getBytes("iso-8859-1"),"utf-8");
			aihao=req.getParameter("aihao");
			id=new String(aihao.getBytes("iso-8859-1"),"utf-8");
		}
		System.out.println("id="+id+"name="+uname+"aihao"+aihao);
	}

}
