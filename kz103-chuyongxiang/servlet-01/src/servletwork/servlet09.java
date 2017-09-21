package servletwork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class servlet09 extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		File file = new File("E:/b.txt"); 
		FileReader fw = new FileReader(file);
		BufferedReader read = new BufferedReader(fw);
		String content="";
		while(read.ready()){
			content =content+ read.readLine();
		}
		out.print(content);
	}
}
