package servletwork;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 10.��һ��jspҳ����ʹ��get��ʽ�ύ�����ı���(������)��һ�������б������б�������ѡ�max,min����Servlet��
  Servlet���ݴ�����������,�����max,�����������������ֵ��������Сֵ��Ȼ���ӡ���ͻ���

 * */
public class Myservlet10 extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int num1 =Integer.parseInt(request.getParameter("num1"));
		int num2 =Integer.parseInt(request.getParameter("num2"));
		int num3 =Integer.parseInt(request.getParameter("num3"));
		String choose = request.getParameter("choose");
		choose = new String(choose.getBytes("iso-8859-1"),"UTF-8");
		if(choose.equals("max")){
			int max = Math.max(num1,Math.max(num2,num3));
			out.print("���ֵ="+max);
		}else{
			int min = Math.min(num1,Math.min(num2,num3));
			out.print("��Сֵ="+min);
		}
	}


}
