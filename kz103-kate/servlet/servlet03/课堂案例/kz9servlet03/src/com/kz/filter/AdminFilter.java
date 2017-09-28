package com.kz.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Ȩ�޹���
public class AdminFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//ǿת
		HttpServletRequest req=  (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//1,��ȡ��¼���û�
		String uname = (String) req.getSession().getAttribute("uname");
		StringBuffer path = req.getRequestURL();
		System.out.println(path);
		//http://localhost:8080/kz9servlet03/admin/admin.jsp
		String contextPath = req.getContextPath();
		System.out.println("contextPath"+contextPath);
		if(uname==null||!uname.equals("admin")){
			//���ܽ���admin.jspҳ��
			resp.sendRedirect(contextPath+"/login.jsp");
			return;//��������ľ�Ҫ�ù�������ֹ����
		}else{
			//����
			chain.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
