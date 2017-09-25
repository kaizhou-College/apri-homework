package com.kz.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener {
	
	private Properties ps ;
	//application在中----web容内存器重启
	///---application销毁了(将访问量，请求次数保存数据库，文件)
	//---application创建了(读取保存在数据库或者文件中的访问量和请求次数)
	
	//application销毁了(将访问量，请求次数保存数据库，文件)
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("application销毁了222222....");
		ServletContext application = sce.getServletContext();
		ps = new Properties();
		//1,获取请求次数和访问量
		int count = (Integer) application.getAttribute("count");
		int all = (Integer)application.getAttribute("all");
		//往ps中添加数据
		ps.setProperty("count", count+"");
		ps.setProperty("all",all+"");
		FileOutputStream fos = null;
		PrintStream out = null;
		try {
			String path = application.getRealPath("/WEB-INF/count.properties");
			
			fos = new FileOutputStream(path);
			out = new PrintStream(fos);
			ps.list(out);
			fos.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//application创建了(读取保存在数据库或者文件中的访问量和请求次数)
	public void contextInitialized(ServletContextEvent sce) {
		ps = new Properties();
		ServletContext application = sce.getServletContext();
		InputStream in = application.getResourceAsStream("/WEB-INF/count.properties");
		try {
			ps.load(in);
			//获取请求次数和访问量
			String count = ps.getProperty("count");
			String all = ps.getProperty("all");
			//将人数放到application对象
			application.setAttribute("count", Integer.parseInt(count));
			application.setAttribute("all", Integer.parseInt(all));
			//在线人数初始值：1
			application.setAttribute("onLine", 1);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
