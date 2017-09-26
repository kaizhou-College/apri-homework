package servletwork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Myservlet09 extends HttpServlet {
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			File file = new File("D:/ÁÒ¾Æ/µÚÈý½×¶Î/work3.txt"); 
			FileReader f = new FileReader(file);
			BufferedReader read = new BufferedReader(f);
			String content="";
			while(read.ready()){
				content =content+ read.readLine();
				
			}
			out.print(content);
		}
		

}
