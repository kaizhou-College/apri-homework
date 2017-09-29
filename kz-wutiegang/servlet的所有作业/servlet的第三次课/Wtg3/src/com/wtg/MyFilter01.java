package com.wtg;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter01 implements Filter {
	public MyFilter01(){
		System.out.println("MyFilter01被创建了");
	}
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("MyFilter01被销毁了");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤器正在执行");
		//放行
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("开始初始化了");
	}

}
