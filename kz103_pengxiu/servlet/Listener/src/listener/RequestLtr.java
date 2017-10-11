package listener;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestLtr implements  ServletRequestListener{

	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("RequestLtr被销毁了");
		long currentTimeMillis = System.currentTimeMillis();
		long date = (Long) arg0.getServletRequest().getAttribute("date");
		System.out.println(currentTimeMillis-date+"毫秒");
		ServletRequest req=arg0.getServletRequest();
		req.setAttribute("date1", currentTimeMillis);
		req.setAttribute("date2",date);
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
		req.setAttribute("date", currentTimeMillis);
	}
}
