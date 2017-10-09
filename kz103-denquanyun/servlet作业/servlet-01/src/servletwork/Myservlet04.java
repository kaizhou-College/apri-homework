package servletwork;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
4.从一个jsp页面上使用post方式提交一个用户编号，一个用户名，和爱好的两个复选项到Servlet，
Servlet接收后处理编码问题，输出到控制台。(继承GenericServlet)*/

public class Myservlet04 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String box[] = req.getParameterValues("hobby");
		String hobby="";
		for (int i = 0; i < box.length; i++) {
			hobby =hobby+","+box[i].toString();
		}
		System.out.println(id+"---"+name+"---"+hobby);
	}
	
}
