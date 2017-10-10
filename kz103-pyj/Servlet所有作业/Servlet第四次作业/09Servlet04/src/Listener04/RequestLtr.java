package Listener04;
/*   дһ��RequestLtr��(�̳�ServletRequestListener),����Request����Ĵ���������,��
   requestInitialized�����еõ�ϵͳ�ĵ�ǰʱ�䣬Ȼ�����õ�ServletRequest�����У������ͼ�¼��
   ����Ŀ�ʼʱ�䣬Ȼ����requestDestroyed������ͬ���ٵõ�ϵͳ�ĵ�ǰʱ�䣬Ȼ��ServletRequest����
   ���ó���ʼʱ�䣬Ȼ�����ʱ����ӡ��������̨ 
*/
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestLtr implements ServletRequestListener{
	public void requestDestroyed(ServletRequestEvent ser) {
		System.out.println("request��������....");
		ServletRequest servletRequest = ser.getServletRequest();
		long desttime=(Long) servletRequest.getAttribute("inittime");
		long timeMillis = System.currentTimeMillis();//requestDestroyed��ϵͳ��ǰʱ��
		long cha=timeMillis-desttime;//��/1000.0
		System.out.println("ʱ����ǣ�"+cha+"����");
	}
	public void requestInitialized(ServletRequestEvent ser) {
		System.out.println("request���󱻴���....");
		long time = System.currentTimeMillis();//requestInitialized��ϵͳ��ǰʱ��
		//System.out.println("init:"+time);
		ServletRequest servletRequest = ser.getServletRequest();
		servletRequest.setAttribute("inittime", time);
	}
}
