package work03.servlet;
/***
 * 4.дһ��jsp,��һ���������������û�����ѡ���Ա�
 * ѡ�񰮺ö����ѡ�򣬸������ϵ��ı�����post�ύ��һ��Servlet��
 * дһ��filter��������������е�ֵ�������Ϊnull���͸���һ�����ַ�����
 * Ȼ����servlet�еõ����ݣ�Ҫ���������������,Ȼ���ӡ������ͻ���.
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
				out.print("�û�����"+user+"		�Ա�:"+sex+"		���ã�"+hoppy+"		�������ϣ�"+zl);
		}

}
