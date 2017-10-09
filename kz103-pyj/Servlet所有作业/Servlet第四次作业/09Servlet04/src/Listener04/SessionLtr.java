package Listener04;
/*计算一个用户登录的时间：
   写一个SessionLtr类(继承HttpSessionListener)，监听session创建和销毁，在
   sessionCreated方法中得到系统的当前时间，然后设置到HttpSession对象中，这样就记录了
   登录的开始时间，然后在sessionDestroyed方法中同样再得到系统的当前时间，然后从HttpSession对象
   中拿出开始时间，然后算出时间差，打印出来到后台 
   访问index.jsp，开始创建Session，在index.jsp中有个超链接"退出",超链接到out.jsp中，销毁session
   (session.invalidate())*/
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionLtr implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent hse) {
		System.out.println("session创建了....");
		long denglu = System.currentTimeMillis();
		HttpSession httpSession = hse.getSession();
		httpSession.setAttribute("denglu", denglu);
	}

	public void sessionDestroyed(HttpSessionEvent hse) {
		System.out.println("session销毁了....");
		long xitong = System.currentTimeMillis();
		HttpSession httpSession = hse.getSession();
		long time =(Long)httpSession.getAttribute("denglu");
		long cha=time-xitong;
		System.out.println("时间差是"+cha);

	}

}
