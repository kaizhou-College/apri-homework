package com.kz.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*
 * ��������ʹ�ò���
 * 1��ʵ��Filter�ӿ�
 * 2��web.xml��������(��ע��������·���͹��˵Ĺ���)
 * 3������
 * 
 * �������ڣ�
 * ���췽��	MyFilter01()  	ֻ�ᱻ����һ�� ��web����������ʱ�����
 * ��ʼ������init();		   	ֻ�ᱻ����һ�� ��web����������ʱ�����
 * ���˵ķ���doFilter();   	�ж��ٴ�����͵��ö��ٴ�
 * ���ٵķ���destroy(); 		�رշ����������²���
 */
public class MyFilter01 implements Filter{
	
	public MyFilter01(){
		System.out.println("������������");
	}

	public void destroy() {
		System.out.println("������������");
	}
	
	//���˵ķ���
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("������ִ�м��.....");
		
		//����
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("��������ʼ����");
	}

}
