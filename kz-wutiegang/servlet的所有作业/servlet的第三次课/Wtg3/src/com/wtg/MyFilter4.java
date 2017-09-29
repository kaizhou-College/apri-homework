package com.wtg;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyFilter4 implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest)request;
		Enumeration enumeration = req.getParameterNames();
		while(enumeration.hasMoreElements()){
			String key =(String) enumeration.nextElement();
			String[] values=req.getParameterValues(key);
			System.out.println(key+"====="+values);
			for (int i = 0; i < values.length; i++) {
				if(values[i].equals("null")){
					values[i]=" ";
				}
			}
		}
	
		chain.doFilter(request, response);
		
		

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
