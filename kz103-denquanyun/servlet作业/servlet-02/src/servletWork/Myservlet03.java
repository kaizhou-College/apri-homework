package servletWork;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * 3.��һ��jspҳ����,��request������������ֵ���û��������룬�Ͱ��ã����ã�ע���Ӧ��value�Ǹ��ַ������飩��,
  Ȼ��ת����һ��Servlet(�̳�GenericServlet)����,�ó��������Ͳ���ֵ����������ͻ��ˣ�ʹ�ñ��
 * */
public class Myservlet03 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = res.getWriter();
		String name = (String) req.getAttribute("name");
		String pwd = (String) req.getAttribute("password");
		String hobby = (String) req.getAttribute("hobby");
		out.print(name);
		out.print(pwd);
		out.print(hobby);
	}

}
