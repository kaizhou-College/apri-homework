package servletwork;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class servlet10 extends  HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		int num3 = Integer.parseInt(request.getParameter("num3"));
		String choose = request.getParameter("choose");
		if(choose.equals("max")){
			int max = Math.max(num1,Math.max(num2,num3));
			out.print("最大值="+max);
		}else{
			int min = Math.min(num1,Math.min(num2,num3));
			out.print("最小值="+min);
		}
	}
}
