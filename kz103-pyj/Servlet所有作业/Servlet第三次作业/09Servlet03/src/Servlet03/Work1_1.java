package Servlet03;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Work1_1 implements Filter{
	public Work1_1(){
		System.out.println("Work1_1������");
	}

	public void destroy() {
		System.out.println("Work1_1������");
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("Work1_1��ִ�м��");
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Work1_1��ʼ��");
	}

}
