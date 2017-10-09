package com.kqw;

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

public class StrFilter implements Filter{

	private Properties ps=null;

	public void destroy() {

	}


	public void doFilter(ServletRequest requset, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//获取文本框内容
		Enumeration enumeration=requset.getParameterNames();
		while(enumeration.hasMoreElements()){
			String key=(String) enumeration.nextElement();
			String[] values=requset.getParameterValues(key);
			//判断文本框是否有非法字符
			for (int i = 0; i < values.length; i++) {
				if(ps.getProperty(values[i])!=null){
					values[i]=ps.getProperty(values[i]);
				}
			}

		}

		//放行
		chain.doFilter(requset, response);


	}


	public void init(FilterConfig filterConfig) throws ServletException {
		//读取非法字符文件
		ps = new Properties();
		InputStream inputStream = filterConfig.getServletContext().getResourceAsStream("WEB-INF/str.properties");

		try {
			ps.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
