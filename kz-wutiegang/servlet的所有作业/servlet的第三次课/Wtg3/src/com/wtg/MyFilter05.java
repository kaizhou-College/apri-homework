package com.wtg;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class MyFilter05 implements Filter {
	private Properties ps;
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		Enumeration enumeration = request.getParameterNames();
		while(enumeration.hasMoreElements()){
			String key = (String) enumeration.nextElement();
			String[] values=request.getParameterValues(key);
			for (int i = 0; i < values.length; i++) {
				if(ps.getProperty(values[i])!=null){
					values[i]=ps.getProperty(values[i]);
				}
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		ps=new Properties();
		InputStream inputStream = filterConfig.getServletContext().getResourceAsStream("WEB-INF/str.properties");
		try {
			ps.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
