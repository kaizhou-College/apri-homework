package com.kqw;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//权限过滤
public class AdminFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
		FilterChain chain) throws IOException, ServletException {
		//强转
		HttpServletRequest req=  (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//1,获取登录的用户
		String name = (String) req.getSession().getAttribute("name");
		StringBuffer path = req.getRequestURL();
		System.out.println(path);
		//http://localhost:8080/kz9servlet03/admin/admin.jsp
		String contextPath = req.getContextPath();
		System.out.println("contextPath"+contextPath);
		if(name==null||!name.equals("admin")){
			//不能进入admin.jsp页面
			resp.sendRedirect(contextPath+"/Admin.jsp");
			return;//如果不放心就要让过滤器终止工作
		}else{
			//放行
			chain.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	

	}

}
