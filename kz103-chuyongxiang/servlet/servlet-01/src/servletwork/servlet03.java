package servletwork;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class servlet03  implements Servlet{
	public  int count =0;
	public void destroy() {
		// TODO Auto-generated method stub
		File file=new File("E/a.txt");
		try {
			FileWriter aa=new FileWriter(file);
			aa.write(this.count);
			aa.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.count=this.count+1;
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		out.println("«Î«Û¡Àservlet03"+count+"¥Œ");
		
	}

}
