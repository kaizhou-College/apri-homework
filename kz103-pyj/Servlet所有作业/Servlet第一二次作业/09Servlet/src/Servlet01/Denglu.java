package Servlet01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Denglu extends HttpServlet{
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		}
		
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			System.out.println("��ʼ����...");
			HttpServletRequest request=(HttpServletRequest) req;
			String method=request.getMethod();
			//��ȡ��������
			String encode=getServletConfig().getInitParameter("encode");
			String name=null;
			String pwd=null;
			if(method.equals("post")){
				req.setCharacterEncoding(encode);
				name=req.getParameter("name");
				pwd=req.getParameter("pwd");
			}
		System.out.println("name="+name+"pwd="+pwd);	
}

}
