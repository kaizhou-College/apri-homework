package com.kz.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//编码过滤
public class EncodeFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//编码问题(请求编码和响应编码)
		//1,强制转换
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		//2,根据请求请求方式解决编码问题
		String method = req.getMethod();
		if(method.equalsIgnoreCase("post")){
			req.setCharacterEncoding("utf-8");
		}else{
			Enumeration enumeration = req.getParameterNames();
			while(enumeration.hasMoreElements()){
				String key = (String) enumeration.nextElement();
				String[] values = req.getParameterValues(key);
				for(int i=0;i<values.length;i++){
					values[i] = new String(values[i].getBytes("iso-8859-1"),"utf-8");
				}
			}
		}
		///响应编码
		res.setContentType("text/html;charset=utf-8");
		//放行
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
