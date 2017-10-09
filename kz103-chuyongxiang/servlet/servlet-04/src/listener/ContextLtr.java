package listener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLtr  implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		long currentTimeMillis = System.currentTimeMillis();
		ServletContext servletContext = arg0.getServletContext();
		long hq = (Long) servletContext.getAttribute("abc");
		long sum = currentTimeMillis-hq;
		File file = new File("E:/a.txt");
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(sum+"毫秒");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	System.out.println("ContextLtr监听器销毁了");
	}

	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ContextLtr监听器创建了");
		long currentTimeMillis = System.currentTimeMillis();
		ServletContext servletContext = arg0.getServletContext();
		servletContext.setAttribute("abc", currentTimeMillis);
	}

}
