package servletWork;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * 3.在一个jsp页面中,向request里面设置三个值（用户名，密码，和爱好（爱好，注意对应的value是个字符串数组））,
  然后转发到一个Servlet(继承GenericServlet)里面,拿出参数名和参数值，并输出到客户端（使用表格）
 * */
public class Myservlet03 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = res.getWriter();
		String name = (String) req.getAttribute("name");
		String pwd = (String) req.getAttribute("password");
		String hobby = (String) req.getAttribute("hobby");
		out.print(name);
		out.print(pwd);
		out.print(hobby);
	}

}
