package work01;
/***
 * 6.从一个jsp页面上使用get方式提交两个文本框，一个下拉列表，
 * 下拉列表中是（+,-,*,/）到Servlet，
 * Servlet根据请求做相应的计算，得到结果后输出到客户端.
 * (要求使用继承HttpServlet的方式完成)
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Srevletwork06 extends HttpServlet {
	public Srevletwork06() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charest=utf-8");
			request.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			if(request.getParameter("result").equals("+")){
				int values = Integer.parseInt(request.getParameter("one"))+Integer.parseInt(request.getParameter("two"));
				out.print(values);
			}
			if(request.getParameter("result").equals("-")){
				int values = Integer.parseInt(request.getParameter("one"))-Integer.parseInt(request.getParameter("two"));
				out.print(values);
			}
			if(request.getParameter("result").equals("*")){
				int values = Integer.parseInt(request.getParameter("one"))*Integer.parseInt(request.getParameter("two"));
				out.print(values);
			}
			if(request.getParameter("result").equals("/")){
				int values = Integer.parseInt(request.getParameter("one"))/Integer.parseInt(request.getParameter("two"));
				out.print(values);
			}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	public void init() throws ServletException {
	}

}
