package kz.servlet_zy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class ServletImplements implements Servlet{
	private ServletConfig config;
	private ServletConfig ServletConfig;
	public ServletImplements(){
		
		System.out.println("����ServletImplements");
	}
	public void destroy() {
		System.out.println("����һ��������β");
		
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.ServletConfig;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return this.getServletInfo()+"ServletImplements���������������ڵ�";
	}

	public void init(ServletConfig config) throws ServletException {
		this.config=config;
		
	}

	public void service(ServletRequest re, ServletResponse rq)
			throws ServletException, IOException {
		//out��servlet���治�����ö�������Ҫ����
		PrintWriter a=rq.getWriter();
		//��ȡmethod�ύ��ʽ
		HttpServletRequest request=(HttpServletRequest)re;
		String method = request.getMethod();
		//��ȡservlet�ı�������
		String encode = config.getInitParameter("encode");	
		String parameter = null;
		if(method.equalsIgnoreCase("post")){
			re.setCharacterEncoding(encode);
			parameter=re.getParameter("zy");
		}else{
			parameter=re.getParameter("zy");
			parameter=new String(parameter.getBytes("iso-8859-1"),"utf-8");
		}
		
		
		
		
		
		//��ҳ������
		a.print(parameter);
		
	}

}
