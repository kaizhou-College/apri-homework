package workFour;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		ServletContext application = se.getSession().getServletContext();
		Object obj = application.getAttribute("all");
		int all=0;
		if(obj==null){
			all=0;
		}else{
			all = (Integer) obj;
		}
		all++;
		application.setAttribute("all",all);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
	}

}
