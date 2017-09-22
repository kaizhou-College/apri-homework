package com.kz.filter;

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

public class CodeFilter implements Filter {
	private Properties ps = null;
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//获取聊天的内容
		//String content = request.getParameter("content");
		Enumeration enumeration = request.getParameterNames();
		while(enumeration.hasMoreElements()){
			String key = (String) enumeration.nextElement();
			String[] values = request.getParameterValues(key);
			//判断否者有非法字符
			for(int i=0;i<values.length;i++){
				if(ps.getProperty(values[i])!=null){
					values[i] = ps.getProperty(values[i]);
				}
				
			}
		}
		//放行
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		//读非法字符文件
		ps = new Properties();
		InputStream inputStream = filterConfig.getServletContext().getResourceAsStream("WEB-INF/code.properties");
		
		try {
			ps.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
