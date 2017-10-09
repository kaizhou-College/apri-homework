package com.kqw;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author 
 * 写一个用户名登录的jsp，可以填写密码和用户名，提交到登录的Encodeservlet中,写一个filter过滤请求解决
 * 请求的中文乱码问题（get/post）和响应的中文乱码问题，然后在servlet中得到数据，然后打印输出到客户端
 */
public class EncodeFilter implements Filter {
	

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//编码问题(请求编码和响应编码)
		//1,强制转换
		//PrintWriter out=response.getWriter();
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
					System.out.println(values[i]);
					values[i] = new String(values[i].getBytes("iso-8859-1"),"utf-8");
				}
			}
		}
		
		///响应编码
		res.setContentType("text/html;charset=utf-8");
		//放行
		chain.doFilter(req, res);
		
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}
