package com.kqw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 *дһ��jsp,jsp��һ���û���¼�ı������û��������룬��post��ʽ�ύ��һ��servlet(Ҫ��ʹ�ü̳�HttpServlet�ķ�ʽ���)��
 *doPost()�����У��õ����ݣ����������̨��Ȼ���Ա�����ʽ����������ͻ���
 *
 *(������)
 */
public class Test5 extends HttpServlet {

		
		protected void service(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
				doPost(req, resp);
				resp.setContentType("text/html;charset=utf-8");
				ServletConfig config=getServletConfig();
				//��������
				//��ȡ�ύ��ʽ��request����
				HttpServletRequest request=(HttpServletRequest)req;
				String method = request.getMethod();
				//��ȡservlet�ı�������
				String encode=getServletConfig().getInitParameter("encode");
				//post�ύ����
				String name =null;
				String pwd = null;
				if(method.equalsIgnoreCase("post")){
					req.setCharacterEncoding(encode);
					name = req.getParameter("name");
					pwd = req.getParameter("pwd");
				}else{//get�ύ
					name = req.getParameter("name");
					name = new String(name.getBytes("iso-8859-1"),"utf-8");
					pwd = req.getParameter("pwd");
					pwd = new String(pwd.getBytes("iso-8859-1"),"utf-8");
				
				}
				
				System.out.println("name===="+name+"pwd===="+pwd);
				
		}
	

}
