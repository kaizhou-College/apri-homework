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
//�������
public class EncodeFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//��������(����������Ӧ����)
		//1,ǿ��ת��
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		//2,������������ʽ�����������
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
		///��Ӧ����
		res.setContentType("text/html;charset=utf-8");
		//����
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
