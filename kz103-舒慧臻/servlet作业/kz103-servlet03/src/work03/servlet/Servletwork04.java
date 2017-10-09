package work03.servlet;
/***
 * 4.写一个jsp,有一个表单，可以输入用户名，选择性别，
 * 选择爱好多个复选框，个人资料的文本域，用post提交到一个Servlet，
 * 写一个filter过滤请求遍历所有的值，如果有为null，就给它一个空字符串，
 * 然后在servlet中得到数据，要解决中文乱码问题,然后打印输出到客户端.
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servletwork04 extends HttpServlet {
		
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
				PrintWriter out = resp.getWriter();
				req.setCharacterEncoding("utf-8");
				resp.setContentType("text/html;charset=utf-8");
				String user = req.getParameter("user");
				String sex = req.getParameter("sex");
				String hoppy = req.getParameter("hoppy");
				String zl = req.getParameter("ziliao");
				out.print("用户名："+user+"		性别:"+sex+"		爱好："+hoppy+"		个人资料："+zl);
		}

}
