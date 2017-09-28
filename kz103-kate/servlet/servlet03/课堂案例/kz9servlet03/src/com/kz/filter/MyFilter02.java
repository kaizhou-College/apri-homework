package com.kz.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * servlet的声明周期和filter的生命周期
 * 1，过滤器在web容器启动的时候创建并初始化，而servlet是在第1次请求的时候才会创建并初始化
 * 2，先进行过滤，后进行服务
 * 3，servlet先销毁，filter后销毁(filter销毁顺序是与web.xml配置一致)
 * 4，filter，servlet构造，初始化，销毁都只会调用一次
 * 
 */
public class MyFilter02 implements Filter {

	public MyFilter02(){
		System.out.println("过滤器MyFilter02创建了");
	}

	public void destroy() {
		System.out.println("过滤器MyFilter02销毁了");
	}
	
	//过滤的方法
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("门卫MyFilter02在执行检查.....");
		
		//放行
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器MyFilter02初始化了");
		String age = filterConfig.getInitParameter("age");
		System.out.println("age=="+age);
	}

}
