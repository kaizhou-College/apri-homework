package com.kz.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * servlet���������ں�filter����������
 * 1����������web����������ʱ�򴴽�����ʼ������servlet���ڵ�1�������ʱ��Żᴴ������ʼ��
 * 2���Ƚ��й��ˣ�����з���
 * 3��servlet�����٣�filter������(filter����˳������web.xml����һ��)
 * 4��filter��servlet���죬��ʼ�������ٶ�ֻ�����һ��
 * 
 */
public class MyFilter02 implements Filter {

	public MyFilter02(){
		System.out.println("������MyFilter02������");
	}

	public void destroy() {
		System.out.println("������MyFilter02������");
	}
	
	//���˵ķ���
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("����MyFilter02��ִ�м��.....");
		
		//����
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("������MyFilter02��ʼ����");
		String age = filterConfig.getInitParameter("age");
		System.out.println("age=="+age);
	}

}
