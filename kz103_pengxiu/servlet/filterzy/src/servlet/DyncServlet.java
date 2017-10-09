package servlet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JTextField;

public class DyncServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String pwd = request.getParameter("pwd");
		FileReader filereader=null;
		String result=null;
		try {
			filereader = new FileReader("C:/Users/www/Desktop/sql作业/新建文本文档");
			BufferedReader bufferedreader=new BufferedReader(filereader);
			while(filereader.ready()){
				result+=bufferedreader.readLine();
			}
			filereader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
		String pwd1=result.substring(4);
		if(pwd.equals(pwd1)){
			response.sendRedirect("success.jsp");
			
		}else{
			response.sendRedirect("error.jsp");
		}
		out.flush();
		out.close();
	}
	public static void main(String[] args) {
		FileReader filereader=null;
		String result=null;
		try {
			filereader = new FileReader("C:/Users/www/Desktop/sql作业/新建文本文档");
			BufferedReader bufferedreader=new BufferedReader(filereader);
			
			while(filereader.ready()){
				result+=bufferedreader.readLine();
			}
			System.out.println(result);
			filereader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} 
		
		System.out.println(result.substring(4));
	}
}




