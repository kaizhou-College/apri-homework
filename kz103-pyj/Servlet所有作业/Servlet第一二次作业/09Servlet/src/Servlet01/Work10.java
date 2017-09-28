package Servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Work10 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		doPost(request, response);

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int num1=Integer.parseInt(request.getParameter("n1"));
		int num2=Integer.parseInt(request.getParameter("n2"));
		int num3=Integer.parseInt(request.getParameter("n3"));
		String xuanze=request.getParameter("dx");
		if(xuanze.equals("max")){
			int max=num1;
			if(max<num2){
				max=num2;
			}
			if(max<num3){
				max=num3;
			}
			out.print(max);
		}else{
			int min=num1;
			if(min>num2){
				min=num2;
			}
			if(min>num3){
				min=num3;
			}

			out.print(min);
		}
	}
}
