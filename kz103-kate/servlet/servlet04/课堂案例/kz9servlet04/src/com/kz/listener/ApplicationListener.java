package com.kz.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//����application����
public class ApplicationListener implements ServletContextListener{
	
	public ApplicationListener(){
		System.out.println("ApplicationListener������");
	}
	//����application������
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("application��������");
	}
	//����application�Ĵ���
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("application��������");
	}

}
