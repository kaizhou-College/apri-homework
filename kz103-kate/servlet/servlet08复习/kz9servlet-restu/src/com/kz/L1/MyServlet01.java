package com.kz.L1;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
//����=====������  Object��������
//����
public  class MyServlet01 implements Servlet {
	private ServletConfig config;
	public MyServlet01() {
		System.out.println("servlet������");
	}
	@Override
	public void destroy() {
		System.out.println("servlet������");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("servlet��ʼ����");
		this.config = config;
		
	}
	
	int i ;
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		HttpServletRequest requeset =(HttpServletRequest) req;
		i++;
		System.out.println("����"+i+"��");
		//res.setContentType("utf-8");
		String encode = this.config.getInitParameter("encode");
		System.out.println("encode==="+encode);
		res.setContentType("text/html;charset="+encode);
		requeset.getSession();
	}
	
}


//������κ�Э��
/*public class MyServlet01 extends GenericServlet{
	
	
	@Override
	public void init() throws ServletException {
		//���Լ��������ʼ��
		
	}
	int i ;
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//û����������ʽ��post  get  head .......
		i++;
		System.out.println("����"+i+"��");
	}
	
}*/
/*public class MyServlet01 extends HttpServlet{
	int i;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		i++;
		System.out.println("����"+i+"��");
	}
	

}*/

