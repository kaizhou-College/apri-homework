package com.kz.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Filter03 implements Filter{
	public Filter03(){
		System.out.println("Filter创建了");
	}
	@Override
	public void destroy() {
		System.out.println("Filter销毁了");
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("name");
		if(name==null){
			System.out.println("进来了");
			response.sendRedirect("save/work3.jsp");
			return;
		}
		System.out.println(name);
		chain.doFilter(req, res);
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Filter初始化了");
	}
}
