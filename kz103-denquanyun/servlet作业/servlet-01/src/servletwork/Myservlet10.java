package servletwork;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 10.从一个jsp页面上使用get方式提交三个文本框(填数字)，一个下拉列表，下拉列表中两个选项（max,min）到Servlet，
  Servlet根据传过来的数据,如果是max,求出这个三个数的最大值，否则最小值，然后打印到客户端

 * */
public class Myservlet10 extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int num1 =Integer.parseInt(request.getParameter("num1"));
		int num2 =Integer.parseInt(request.getParameter("num2"));
		int num3 =Integer.parseInt(request.getParameter("num3"));
		String choose = request.getParameter("choose");
		choose = new String(choose.getBytes("iso-8859-1"),"UTF-8");
		if(choose.equals("max")){
			int max = Math.max(num1,Math.max(num2,num3));
			out.print("最大值="+max);
		}else{
			int min = Math.min(num1,Math.min(num2,num3));
			out.print("最小值="+min);
		}
	}


}
