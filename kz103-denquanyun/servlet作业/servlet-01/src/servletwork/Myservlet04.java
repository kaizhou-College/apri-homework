package servletwork;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
4.��һ��jspҳ����ʹ��post��ʽ�ύһ���û���ţ�һ���û������Ͱ��õ�������ѡ�Servlet��
Servlet���պ���������⣬���������̨��(�̳�GenericServlet)*/

public class Myservlet04 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String box[] = req.getParameterValues("hobby");
		String hobby="";
		for (int i = 0; i < box.length; i++) {
			hobby =hobby+","+box[i].toString();
		}
		System.out.println(id+"---"+name+"---"+hobby);
	}
	
}
