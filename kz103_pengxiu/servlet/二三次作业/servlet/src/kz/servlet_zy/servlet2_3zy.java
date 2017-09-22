package kz.servlet_zy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class servlet2_3zy  extends GenericServlet{

	/**
	 * @param args
	 */

	static String[] name=null;
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		arg1.setContentType("text/html;charset=utf-8");
		arg0.setCharacterEncoding("utf-8");
		PrintWriter out=arg1.getWriter();
		 name=arg0.getParameterValues("name");
		String[] pwd = arg0.getParameterValues("pwd");
		String[] ah = arg0.getParameterValues("ah");
		
		out.print(" <table border='1' >");
			for (int i = 0; i < name.length; i++) {
				out.print("<tr>");
				out.print("<td>");
				out.print(name[i]);
				out.print("</td>");
				out.print("<td>");
				out.print(pwd[i]);
				out.print("</td>");
			}
				
				out.print("<td>");
				for (int j = 0; j < ah.length; j++) {
					out.print(ah[j]+" ");
				}
				out.print("</td>");
				out.print("</tr>");
			
		
		out.print(" </table>");
	}
	
}

















