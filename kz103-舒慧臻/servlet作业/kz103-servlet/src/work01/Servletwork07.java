package work01;
/***
 * 
7.（准备一个Users表，列名（id，name,pwd),插入一些数据）
在一个jsp页面写上“显示用户”的超链接到一个servlet，带 上
用户名和密码，在servlet中拿到数据，查找数据库判断用户名
和密码是否正确，如果正确，查到数据，以表格的形式打印 到客
户端，否则输出不正确(要求使用继承HttpServlet的方式完成)
  提醒：编码问题，超链接是get方式
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servletwork07 extends HttpServlet {
	public Servletwork07() {
		super();
	}
	public void destroy() {
		super.destroy(); //
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	public void init() throws ServletException {
	}

}
