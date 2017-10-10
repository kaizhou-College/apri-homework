package com.accp.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet1 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//System.out.println("�����ˡ�����");
		
		//requestǿ��ת��
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		//��ȡ���������:get/post
		String method = request.getMethod();
		//�ж������post����
		if("POST".equalsIgnoreCase(method)){
			//����post��������뷽ʽ
			request.setCharacterEncoding("utf-8");
		}else{
			//��ǰ��ʵ�ַ�ʽ
			//String num  = new String(request.getParameter("number").getBytes("iso-8859-1"),"utf-8");
			//String number  = new String(request.getParameter("uname").getBytes("iso-8859-1"),"utf-8");
			
			//��ȡ�������в�����name,���ص���һ������������
			//Enumeration�൱��Iterator
			Enumeration<String> ems =  request.getParameterNames();
			//�жϵ����������Ƿ�����һ��Ԫ��
			while(ems.hasMoreElements()){
				//ȡ�����������е���һ��Ԫ��
				String name = ems.nextElement();
				//����ȡ����name����ȡ����name����Ӧ��valueֵ
				String [] values = request.getParameterValues(name);
				//ѭ���������ÿ��ֵ������ת��
				for(int i=0;i<values.length;i++){
					//ת�룬��������ĵ�iλ���¸�ֵ
					values[i] = new String(values[i].getBytes("iso-8859-1"),"utf-8");
				}
			}
		}
		
		//������Ӧ�ı��뷽ʽ
		response.setContentType("text/html;charset=utf-8");
		
		//���ԣ���ȡֵ����ӡ���
		//ֱ�ӻ�ֵ������Ҫ�ٹ�עpost��get��ʽ�ı�������
		String num = request.getParameter("number");
		String uname = request.getParameter("uname");
		String [] hbs = request.getParameterValues("hobby");
		
		System.out.println("���:"+num);
		System.out.println("����:"+uname);
		System.out.println("����:");
		for(String str:hbs){
			System.out.print(str+" ");
		}
		
		
	}

	
}
