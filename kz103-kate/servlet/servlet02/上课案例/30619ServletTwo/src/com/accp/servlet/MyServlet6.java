package com.accp.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * ��ȡweb-inf�������Դ
 * @author Administrator
 *
 */
public class MyServlet6 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		//��ȡapplication����
		ServletContext context = this.getServletContext();
		
		//�ֽ�������
		//ͨ��ServletContext��ȡһ��web-inf�������Դ��ת���ֽ�������
		InputStream is =  context.getResourceAsStream("/WEB-INF/a.html");
		//����������
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		//��ʼ������
		String str = br.readLine();//��һ��
		
		//������Ӧ��ʽ
		res.setContentType("text/html;charset=utf-8");
		//��ȡ��Ӧ�����
		PrintWriter out = res.getWriter();
		while(str!=null){//�������������
			//��Ӧ��ȥ
			out.print(str);
			str = br.readLine();//������ȡ��һ������
		}
		
		out.close();
		br.close();
		is.close();
		
		
		
	}

	
}
