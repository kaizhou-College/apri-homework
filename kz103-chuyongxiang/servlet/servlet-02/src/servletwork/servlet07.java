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
         //ֻ��HttpServletRequest�ڿ��Եõ�ͷ��Ϣ
		HttpServletRequest request=(HttpServletRequest)req;		
        Enumeration enums=request.getHeaderNames();//�õ�����ͷ��һ��ö��
		out.print("<table border='1'>");//�Ա��ķ�ʽ��ӡ����	
	    while(enums.hasMoreElements()){
	    	out.print("<tr>");
			String key=(String)enums.nextElement();//��ö����ȡ�ü�
			String value=request.getHeader(key); //ͨ����ȡֵ
			out.print("<td>"+key+"</td>");
			out.print("<td>"+value+"</td>");
			out.print("</tr>");
		}
		out.print("</table>");
	}
}
