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
	//����
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ContextListener������");
		long endtime = System.currentTimeMillis();
		ServletContext servletContext = sce.getServletContext();
		long starttime = (Long)servletContext.getAttribute("start");
		long sjc = endtime-starttime;
		System.out.println("ʱ���========"+sjc+"����");
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
	
	//����
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ContextListener������");
		long start = System.currentTimeMillis();
		ServletContext servletContext = sce.getServletContext();
		servletContext.setAttribute("start", start);
	}

}
