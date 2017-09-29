package com.wtg.Listener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLtr implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("ContextLtr销毁了");
		long Ptime = System.currentTimeMillis();
		ServletContext context = sce.getServletContext();
		long Ctime = (Long) context.getAttribute("Ctime");
		long time=Ptime-Ctime;
		System.out.println("==="+time);
		FileWriter fw=null;
		PrintWriter pw=null;
		try {
			fw = new FileWriter("E:/a.txt");
			pw=new PrintWriter(fw);
			pw.print(time);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pw.close();
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("ContextLtr创建了");
		long Ctime = System.currentTimeMillis();
		ServletContext context = sce.getServletContext();
		context.setAttribute("Ctime", Ctime);
	}

}
