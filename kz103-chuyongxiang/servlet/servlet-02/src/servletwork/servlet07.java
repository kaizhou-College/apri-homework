package servletwork;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class servlet07 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html;charset=GBK");
		req.setCharacterEncoding("GBK");
		PrintWriter out=res.getWriter();
         //只有HttpServletRequest在可以得到头信息
		HttpServletRequest request=(HttpServletRequest)req;		
        Enumeration enums=request.getHeaderNames();//得到请求头的一个枚举
		out.print("<table border='1'>");//以表格的方式打印出来	
	    while(enums.hasMoreElements()){
	    	out.print("<tr>");
			String key=(String)enums.nextElement();//从枚举中取得键
			String value=request.getHeader(key); //通过键取值
			out.print("<td>"+key+"</td>");
			out.print("<td>"+value+"</td>");
			out.print("</tr>");
		}
		out.print("</table>");
	}
}
