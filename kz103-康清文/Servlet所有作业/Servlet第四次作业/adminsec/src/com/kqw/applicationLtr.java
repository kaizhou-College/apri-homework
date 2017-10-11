package com.kqw;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class applicationLtr implements ServletContextListener {
	
	private Properties ps;
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext application = sce.getServletContext();
		ps=new Properties();
		//count是请求次数
		int count = (Integer) application.getAttribute("count");
		//all是访问量
		int all = (Integer) application.getAttribute("all");
		//将访问量和请求次数放到properties中
		ps.setProperty("count", count+"");
		ps.setProperty("all", all+"");
		String path=application.getRealPath("/WEB-INF/math.properties");
		FileOutputStream fos=null;
		PrintStream out=null;
		try {
			fos=new FileOutputStream(path);
			out=new PrintStream(fos);
			ps.list(out);
			fos.close();
			out.close();
		} catch (FileNotFoundException e) {
	
			e.printStackTrace();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
	}
	//在创建的时候从文本文当中或者从数据库中读取出来
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ps=new Properties();
		ServletContext application = sce.getServletContext();
		InputStream in = application.getResourceAsStream("/WEB-INF/math.properties");
		try {
			ps.load(in);
			
			 String all = ps.getProperty("all");
			 String count = ps.getProperty("count");
			
			application.setAttribute("all",Integer.parseInt(all));
			
			application.setAttribute("count", Integer.parseInt(count));
		
			//在线人数初始化
			application.setAttribute("onLine", 0);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
