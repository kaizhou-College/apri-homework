package work04;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
//创建
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		long start = System.currentTimeMillis();
		HttpSession session = se.getSession();
		session.setAttribute("start", start);
	}
//销毁
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		long end = System.currentTimeMillis();
		HttpSession session = se.getSession();
		long starttime = (Long) session.getAttribute("start");
		long sjc = end-starttime;
		System.out.println("时间差========="+sjc);
	}

}
