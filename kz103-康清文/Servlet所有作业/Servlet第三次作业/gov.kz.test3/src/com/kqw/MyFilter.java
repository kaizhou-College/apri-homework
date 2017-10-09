package com.kqw;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 
 * @author 
 * 写一个例子，测试filter和servlet的生命周期
 */
public class MyFilter implements Filter{
	//构造
	public MyFilter(){
		System.out.println("过滤器被创建了");
		
	}
	
	//销毁
	public void destroy() {
	    System.out.println("过滤器被销毁了");
		
	}

	//过滤放行的方法
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			System.out.println("过滤器在检查");
			
			//放行
			chain.doFilter(request, response);
	}

	//初始化
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("过滤器初始化了");
		
	}

}

