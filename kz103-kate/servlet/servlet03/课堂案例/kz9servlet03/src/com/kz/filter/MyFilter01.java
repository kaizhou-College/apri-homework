package com.kz.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*
 * 过滤器的使用步骤
 * 1，实现Filter接口
 * 2，web.xml进行配置(备注过滤器的路径和过滤的规则)
 * 3，测试
 * 
 * 生命周期：
 * 构造方法	MyFilter01()  	只会被调用一次 在web容器启动的时候调用
 * 初始化方法init();		   	只会被调用一次 在web容器启动的时候调用
 * 过滤的方法doFilter();   	有多少次请求就调用多少次
 * 销毁的方法destroy(); 		关闭服务器或重新部署
 */
public class MyFilter01 implements Filter{
	
	public MyFilter01(){
		System.out.println("过滤器创建了");
	}

	public void destroy() {
		System.out.println("过滤器销毁了");
	}
	
	//过滤的方法
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("门卫在执行检查.....");
		
		//放行
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器初始化了");
	}

}
