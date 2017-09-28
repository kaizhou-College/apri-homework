package com.kz.listenter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListener02 implements ServletContextListener{
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		long currentTimeMillis = System.currentTimeMillis();
		ServletContext servletContext = arg0.getServletContext();
		long hehe = (Long) servletContext.getAttribute("haha");
		long sum = currentTimeMillis-hehe;
		File file = new File("D:/text.txt");
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(sum+"∫¡√Î");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		long currentTimeMillis = System.currentTimeMillis();
		ServletContext servletContext = arg0.getServletContext();
		servletContext.setAttribute("haha", currentTimeMillis);
	}
}
