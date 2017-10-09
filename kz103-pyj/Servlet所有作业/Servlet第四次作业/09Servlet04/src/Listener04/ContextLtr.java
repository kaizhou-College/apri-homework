package Listener04;
/*计算项目的运行时间：
   写一个ContextLtr类(继承ServletContextListener)，监听ServletContext的创建和销毁，在
   contextInitialized方法中得到系统的当前时间，然后设置到ServletContext对象中，这样就记录了
   项目开启的开始时间，然后在contextDestroyed方法中同样再得到系统的当前时间，然后ServletContext对象
   中拿出开始时间，然后算出时间差，用文件输出流将时间差输出到一个文件里.

   （开启tomcat,过一定的时间关闭tomcat）*/
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLtr implements ServletContextListener{
	private Properties ps;
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("context销毁了...");
		long newtime = System.currentTimeMillis();//contextDestroyed系统当前时间
		ServletContext servletContext = sce.getServletContext();
		long getold =(Long) servletContext.getAttribute("oldtime");
		long getchacha=newtime-getold;
		System.out.println("作业2的时间差是"+getchacha+"毫秒");
		//获取时间差
		int getcha=(Integer)servletContext.getAttribute("cha");
		//往ps中添加数据
		ps.setProperty("getcha", getcha+"");
		FileOutputStream fos=null;
		PrintStream out=null;
		try {
			String path=servletContext.getRealPath("/WEB-INF/work2.properties");
			fos=new FileOutputStream(path);
			out=new PrintStream(fos);
			fos.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("context创建了...");
		long oldtime = System.currentTimeMillis();//contextInitialized系统当前时间
		ServletContext servletContext = sce.getServletContext();
		servletContext.setAttribute("oldtime", oldtime);
		ps=new Properties();
		InputStream in = servletContext.getResourceAsStream("/WEB-INF/work2.properties");
		try {
			ps.load(in);
			//获取时间差
			String getcha=ps.getProperty("getcha");
			//把时间差放到servletContext对象
			servletContext.setAttribute("getcha", getcha);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
