package com.kz.listenter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener04 implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent cd) {
		System.out.println("application销毁了");
	}
	@Override
	public void contextInitialized(ServletContextEvent ci) {
		System.out.println("application创建了");
	}
}
