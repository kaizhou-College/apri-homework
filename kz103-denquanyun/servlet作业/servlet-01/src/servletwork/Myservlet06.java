package servletwork;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*6.��һ��jspҳ����ʹ��get��ʽ�ύ�����ı���һ�������б������б����ǣ�+,-,*,/����Servlet��
  Servlet������������Ӧ�ļ��㣬�õ������������ͻ���.(Ҫ��ʹ�ü̳�HttpServlet�ķ�ʽ���)*/
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
