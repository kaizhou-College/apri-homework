package Listener04;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class Work4request implements ServletRequestListener{

	public void requestDestroyed(ServletRequestEvent sre) {
		
	}
//关于请求次数只要reques请求一次就+1
	public void requestInitialized(ServletRequestEvent sre) {
		ServletContext application = sre.getServletContext();
		Object object = application.getAttribute("count");
		int count=0;
		if(object==null){
			count=0;
		}else{
			count=(Integer)object;
		}
		count++;
		application.setAttribute("count", count);
	}
}
