package Servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Yunsuan extends HttpServlet{
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	PrintWriter out = resp.getWriter();
	int num1=Integer.parseInt(req.getParameter("ts1"));
	int num2=Integer.parseInt(req.getParameter("ts2"));
	String xiala=req.getParameter("xiala");
	int sum=0;
	if(xiala.equals("+")){
		 sum = num1+num2;
	}else if(xiala.equals("-")){
		sum=num1-num2;
	}else if(xiala.equals("*")){
		sum=num1*num2;
	}else{
		sum=num1/num2;
	}
	out.print(sum);
}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
doPost(req, resp);
	}
}
