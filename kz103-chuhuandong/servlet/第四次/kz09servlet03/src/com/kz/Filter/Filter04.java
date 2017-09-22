package com.kz.Filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class Filter04 implements Filter{
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	public Filter04(){
		System.out.println("我创建了....filter04");
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		chain.doFilter(req, res);
		HttpServletRequest request = (HttpServletRequest) req;
		Enumeration names = req.getParameterNames();
		while(names.hasMoreElements()){
			String name = (String)names.nextElement();
			String num = request.getHeader(name);
			System.out.println(num);
		}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
}
