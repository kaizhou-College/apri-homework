package listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionLtr implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		long currentTimeMillis = System.currentTimeMillis();
		HttpSession request = se.getSession();
		long hq = (Long) request.getAttribute("abc");
		System.out.println(hq-currentTimeMillis+"毫秒");
		System.out.println("SessionLtr监听器销毁了");
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("SessionLtr监听器创建了");
		long currentTimeMillis = System.currentTimeMillis();
		HttpSession request = se.getSession();
		request.setAttribute("abc", currentTimeMillis);
	}

}
