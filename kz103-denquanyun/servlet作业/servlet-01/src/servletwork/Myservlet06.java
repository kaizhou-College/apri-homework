package servletwork;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*6.从一个jsp页面上使用get方式提交两个文本框，一个下拉列表，下拉列表中是（+,-,*,/）到Servlet，
  Servlet根据请求做相应的计算，得到结果后输出到客户端.(要求使用继承HttpServlet的方式完成)*/
public class Myservlet06 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		String math = req.getParameter("math");
		int sum = 0;
		if(math.equals("+")){
			sum=num1+num2;
		}else if(math.equals("-")){
			sum = num1-num2;
		}else if(math.equals("*")){
			sum = num1*num2;
		}else{
			sum = num1/num2;
		}
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print(sum);
	}

}
