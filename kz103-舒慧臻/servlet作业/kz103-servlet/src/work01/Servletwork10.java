package work01;
/***
 * 10.��һ��jspҳ����ʹ��get��ʽ
 * �ύ�����ı���(������)��һ�������б�
 * �����б�������ѡ�max,min����Servlet��Servlet���ݴ�����������,
 * �����max,�����������������ֵ��������Сֵ��Ȼ���ӡ���ͻ���
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
				out.print("���ֵ��"+max);
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
				out.print("��Сֵ��"+min);
				
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
