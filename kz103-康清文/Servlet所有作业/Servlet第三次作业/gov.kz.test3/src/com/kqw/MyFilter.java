package com.kqw;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 
 * @author 
 * дһ�����ӣ�����filter��servlet����������
 */
public class MyFilter implements Filter{
	//����
	public MyFilter(){
		System.out.println("��������������");
		
	}
	
	//����
	public void destroy() {
	    System.out.println("��������������");
		
	}

	//���˷��еķ���
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			System.out.println("�������ڼ��");
			
			//����
			chain.doFilter(request, response);
	}

	//��ʼ��
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("��������ʼ����");
		
	}

}

