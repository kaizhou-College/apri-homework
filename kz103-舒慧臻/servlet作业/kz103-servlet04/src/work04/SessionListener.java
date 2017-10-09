package work04;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
//����
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		long start = System.currentTimeMillis();
		HttpSession session = se.getSession();
		session.setAttribute("start", start);
	}
//����
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		long end = System.currentTimeMillis();
		HttpSession session = se.getSession();
		long starttime = (Long) session.getAttribute("start");
		long sjc = end-starttime;
		System.out.println("ʱ���========="+sjc);
	}

}
