package Listener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * 2.计算项目的运行时间：

   写一个ContextLtr类(继承ServletContextListener)，监听ServletContext的创建和销毁，在
   contextInitialized方法中得到系统的当前时间，然后设置到ServletContext对象中，这样就记录了
   项目开启的开始时间，然后在contextDestroyed方法中同样再得到系统的当前时间，然后ServletContext对象
   中拿出开始时间，然后算出时间差，用文件输出流将时间差输出到一个文件里.

   （开启tomcat,过一定的时间关闭tomcat）
 * */
public class MyListener02 implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("application销毁了");
		long end = System.currentTimeMillis();
		ServletContext application = sce.getServletContext();
		long start = (Long) application.getAttribute("start");
		long time = end-start;
		System.out.println("start====="+start+"		end===="+end);
		System.out.println("时间差："+time/60+"秒");
		File file = new File("D:/烈酒/第三阶段/kz-103/servlet-04/readme.txt");
		try {
			FileWriter fw = new FileWriter(file);
			fw.write("时间差"+time/60+"秒");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("application创建了");
		long start = System.currentTimeMillis();
		ServletContext application = sce.getServletContext();
		application.setAttribute("start",start);
	}

}
