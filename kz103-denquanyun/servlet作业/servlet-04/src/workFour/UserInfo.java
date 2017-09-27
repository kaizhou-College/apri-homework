package workFour;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class UserInfo implements HttpSessionBindingListener{
	public static int count=0;
	private String name;
	private String pwd;
	public UserInfo(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}
	
	
	public static void setCount(int count) {
		UserInfo.count = count;
	}

	public UserInfo() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		count++;
		System.out.println("多少人多少人"+count);
		ServletContext application = event.getSession().getServletContext();
		application.setAttribute("online",count);
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		count--;
		ServletContext application = event.getSession().getServletContext();
		application.setAttribute("online",count);
	}
	public static int getCount() {
		return count;
	}
}
