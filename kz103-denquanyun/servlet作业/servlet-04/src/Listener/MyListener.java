package Listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/*
 * 1.����һ�����������ʱ�䣺

   дһ��RequestLtr��(�̳�ServletRequestListener),����Request����Ĵ���������,��
   requestInitialized�����еõ�ϵͳ�ĵ�ǰʱ�䣬Ȼ�����õ�ServletRequest�����У������ͼ�¼��
   ����Ŀ�ʼʱ�䣬Ȼ����requestDestroyed������ͬ���ٵõ�ϵͳ�ĵ�ǰʱ�䣬Ȼ��ServletRequest����
   ���ó���ʼʱ�䣬Ȼ�����ʱ����ӡ��������̨ 

 * */

public class MyListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stu
		System.out.println("request��������");
		ServletRequest servletRequest = sre.getServletRequest();
		long time = (Long)servletRequest.getAttribute("start");
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println("start====="+time+"		currentTimeMillis===="+currentTimeMillis);
		long sc = currentTimeMillis-time;
		System.out.println("ʱ��"+sc+"����");

	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub

		System.out.println("request��������");
		long timeMillis = System.currentTimeMillis();
		ServletRequest servletRequest = sre.getServletRequest();
		servletRequest.setAttribute("start",timeMillis);

	}

}
