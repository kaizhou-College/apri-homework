package com.kz.listener;

import java.io.IOException;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyServlet extends HttpServlet {
	public MyServlet(){
		System.out.println("MyServlet������");
	}
	@Override
	public void destroy() {
		System.out.println("MyServlet������");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("MyServlet��ʼ������");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("MyServlet�ڷ���....");
		//�õ�session����
		HttpSession session = req.getSession();
		//session.setMaxInactiveInterval(interval)
	}
}
