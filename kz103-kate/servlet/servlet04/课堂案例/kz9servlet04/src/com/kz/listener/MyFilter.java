package com.kz.listener;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {
	public MyFilter(){
		System.out.println("MyFilter��������");
	}
	
	public 	void destroy() {
		System.out.println("MyFilter������");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("MyFilter������");
		//����
		chain.doFilter(request, response);

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("MyFilter��ʼ����");
	}

}
