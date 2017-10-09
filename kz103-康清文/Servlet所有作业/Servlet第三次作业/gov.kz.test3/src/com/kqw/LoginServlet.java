package com.kqw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author 
 * ,在servlet中解决post方式的中文乱码，然后拿到用户名,将用户名设置到session中，
 *然后重定向“/save/save.jsp”,准备一个过滤器，过滤掉“/save/save.jsp”的请求，在doFilter()中检查session里面的值是否为空，
 * 如果为空，重定向到登录页面。注意:filter配置。
 *
 */
public class LoginServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
			String name=req.getParameter("name");
			String pwd=req.getParameter("pwd");
			//1,要将用户名和密码---session
			req.getSession().setAttribute("name",name);
			//2，跳到Admin.jsp页面 这里必须要用重定向 
			res.sendRedirect("save/save.jsp");
	}
}
