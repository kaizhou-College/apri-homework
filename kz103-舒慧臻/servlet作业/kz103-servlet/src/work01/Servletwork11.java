package work01;
/***
 * 11.在一个jsp页面写一个表单，其中一个文本框，
 * 可以输入用户的编号，提交到一个servlet，
 * 根据编号删除数据(要求使用继承HttpServlet的方式完成)
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.userself;

public class Servletwork11 extends HttpServlet {
	public Servletwork11() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			userself user = new userself();
			
	}

	public void init() throws ServletException {
	}

}
