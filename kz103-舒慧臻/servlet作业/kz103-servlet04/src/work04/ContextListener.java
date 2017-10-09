package work04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
	//销毁
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ContextListener销毁了");
		long endtime = System.currentTimeMillis();
		ServletContext servletContext = sce.getServletContext();
		long starttime = (Long)servletContext.getAttribute("start");
		long sjc = endtime-starttime;
		System.out.println("时间差========"+sjc+"毫秒");
		FileWriter fw = null;
		PrintWriter pw =  null;
		try {
			fw = new FileWriter("D:/shijiancha.txt");
			pw = new PrintWriter(fw);
			pw.print(sjc);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(pw!=null){
					pw.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				if(fw!=null){
					fw.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	//创建
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ContextListener创建了");
		long start = System.currentTimeMillis();
		ServletContext servletContext = sce.getServletContext();
		servletContext.setAttribute("start", start);
	}

}
