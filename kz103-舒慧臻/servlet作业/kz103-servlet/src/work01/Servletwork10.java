package work01;
/***
 * 10.从一个jsp页面上使用get方式
 * 提交三个文本框(填数字)，一个下拉列表，
 * 下拉列表中两个选项（max,min）到Servlet，Servlet根据传过来的数据,
 * 如果是max,求出这个三个数的最大值，否则最小值，然后打印到客户端
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servletwork10 extends HttpServlet {
	public Servletwork10() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			int a = Integer.parseInt(request.getParameter("one"));
			int b = Integer.parseInt(request.getParameter("two"));
			int c = Integer.parseInt(request.getParameter("there"));
			String names = request.getParameter("change");
			if(names.equals("max")){
				int max = a;
				if(b>a){
					max = b;
				}else if(c>b){
					max = c;
				}else if(c>a){
					max = c;
				}
				out.print("最大值："+max);
			}
			if(names.equals("min")){
				int min = a ;
				if(b<a){
					min = b;
				}else if(c<b){
					min = c;
				}else if(c<a){
					min = c;
				}
				out.print("最小值："+min);
				
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	}
	public void init() throws ServletException {
	}

}
