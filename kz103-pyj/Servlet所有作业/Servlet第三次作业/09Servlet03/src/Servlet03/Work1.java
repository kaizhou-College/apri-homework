package Servlet03;
//дһ�����ӣ�����filter��servlet����������
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class Work1 implements Filter{
	public void Work1(){
		System.out.println("Work1������");
	}
	public void destroy() {
		System.out.println("Work1������");
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("Work1��ִ�м��");
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Work1��ʼ��");
	}



}
