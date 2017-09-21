package work02;
/***
 * 2.写一个Servlet（）(继承GenericServlet),
 * 通过request得到请求头的信息,并将头信息以excel的形式输出给客户端
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servletwork02 extends GenericServlet {
	public Servletwork02() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	}
	public void init() throws ServletException {
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) res;
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			PrintWriter out = response.getWriter();
			Enumeration<String> names = request.getHeaderNames();
			out.write("<table border='1'>");
			while(names.hasMoreElements()){
				out.write("<tr>");
				String key = (String)names.nextElement();
				out.write("<td>"+key+"</td>");
				String value = request.getHeader(key);
				out.write("<td>"+value+"</td>");
				out.write("</tr>");
			}
			out.write("</table>");
		
	}

}
