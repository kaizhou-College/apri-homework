package work01;
/****.��һ��jspҳ����ʹ��post��ʽ�ύһ���û���ţ�һ���û�����
 * �Ͱ��õ�������ѡ�Servlet��
 * Servlet���պ���������⣬���������̨��(�̳�GenericServlet)
 * 
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servletwork04 implements Servlet {

	private static final ServletRequest HttpServletRequest = null;
	private ServletConfig config;

	public Servletwork04() {
		super();
	}

	public void destroy() {		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	}

	public void init() throws ServletException {
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			//��ȡ�ύ��ʽ��request����
			HttpServletRequest resquest = (HttpServletRequest) req;
			String method = resquest.getMethod();
			//��ȡservlet�ı�������
			String encode = config.getInitParameter("encode");
			//post�ύ����
			String uname = null;
			String upwd = null;
			if(method.equalsIgnoreCase("post")){
				req.setCharacterEncoding(encode);
				uname = req.getParameter("uname");
				upwd = req.getParameter("pwd");
			}else{
				//get�ύ
				uname = req.getParameter("uname");
				uname = new String(uname.getBytes("iso-8859-1"), "utf-8");
				upwd = req.getParameter("pwd");
				
			}
			out.println("uname====="+uname+"-----upwd====="+upwd);
	}

}
