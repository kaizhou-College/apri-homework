package Listener04;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Work4Session implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent hse) {
		//获取原来在application中保存的人数和访问次数
		ServletContext application = hse.getSession().getServletContext();
		Object object = application.getAttribute("start");
		int start=0;
		if(object==null){
			start=0;
		}else{
			start=(Integer)object;
		}
		object=application.getAttribute("cishu");
		int cishu=0;
		if(object==null){
			cishu=0;
		}else{
			cishu=(Integer)object;
		}
		//在原来访问的次数和在线人数+1
		cishu++;
		start++;
		//最后保持新的人数和访问次数
		application.setAttribute("start", start);
		application.setAttribute("cishu", cishu);
	}
//如果退出那么在线人数就-1
	public void sessionDestroyed(HttpSessionEvent hse) {
		//先获取原来的在线人数
		ServletContext application = hse.getSession().getServletContext();
		Object object = application.getAttribute("start");
		int start=0;
		if(object==null){
			start=0;
		}else{
			start=(Integer)object;
			//然后在原来的基础-1
			start--;
		}
		//最后保持新的在线人数
		application.setAttribute("start", start);
	}

}
