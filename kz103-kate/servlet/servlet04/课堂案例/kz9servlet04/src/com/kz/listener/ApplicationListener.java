package com.kz.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//监听application对象
public class ApplicationListener implements ServletContextListener{
	
	public ApplicationListener(){
		System.out.println("ApplicationListener出生了");
	}
	//监听application的销毁
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("application被销毁了");
	}
	//监听application的创建
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("application被创建了");
	}

}
