package work01;
/***
 * 
7.��׼��һ��Users��������id��name,pwd),����һЩ���ݣ�
��һ��jspҳ��д�ϡ���ʾ�û����ĳ����ӵ�һ��servlet���� ��
�û��������룬��servlet���õ����ݣ��������ݿ��ж��û���
�������Ƿ���ȷ�������ȷ���鵽���ݣ��Ա�����ʽ��ӡ ����
���ˣ������������ȷ(Ҫ��ʹ�ü̳�HttpServlet�ķ�ʽ���)
  ���ѣ��������⣬��������get��ʽ
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servletwork07 extends HttpServlet {
	public Servletwork07() {
		super();
	}
	public void destroy() {
		super.destroy(); //
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	public void init() throws ServletException {
	}

}
