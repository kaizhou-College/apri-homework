package servletwork;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet06 extends HttpServlet{
	public int num3=0;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String fuhao = request.getParameter("fuhao");
		if(fuhao.equals("+")){
			num3=num1+num2;
		}else if(fuhao.equals("-")){
			num3=num1-num2;
		}else if(fuhao.equals("/")){
			num3=num1*num2;
		}else{
			num3=num1/num2;
		}
		out.println(num3);
	}
}
