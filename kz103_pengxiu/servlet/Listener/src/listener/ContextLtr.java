package listener;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.http.HttpSession;

public class ContextLtr implements  ServletContextListener{

	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("RequestLtr被销毁了");
		long currentTimeMillis = System.currentTimeMillis();
		long date = (Long) arg0.getServletRequest().getAttribute("c");
		System.out.println(currentTimeMillis-date+"毫秒");
		ServletRequest req=arg0.getServletRequest();
		req.setAttribute("a", currentTimeMillis);
		req.setAttribute("b",currentTimeMillis-date);
		PrintWriter wf=null;
		try {
			wf=new PrintWriter("C:/Users/www/Desktop/sql作业/新建文本文档");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wf.print(currentTimeMillis-date);
		wf.close();
	}

	public void requestInitialized(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("RequestLtr创建");
		long currentTimeMillis = System.currentTimeMillis();
		ServletRequest req = arg0.getServletRequest();
		req.setAttribute("c", currentTimeMillis);
	}
	

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
	
	
	
	
}
