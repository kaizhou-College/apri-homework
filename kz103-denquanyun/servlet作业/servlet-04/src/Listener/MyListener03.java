package Listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*
 * 3.����һ���û���¼��ʱ�䣺

   дһ��SessionLtr��(�̳�HttpSessionListener)������session���������٣���
   sessionCreated�����еõ�ϵͳ�ĵ�ǰʱ�䣬Ȼ�����õ�HttpSession�����У������ͼ�¼��
   ��¼�Ŀ�ʼʱ�䣬Ȼ����sessionDestroyed������ͬ���ٵõ�ϵͳ�ĵ�ǰʱ�䣬Ȼ���HttpSession����
   ���ó���ʼʱ�䣬Ȼ�����ʱ����ӡ��������̨ 

   ����index.jsp����ʼ����Session����index.jsp���и�������"�˳�",�����ӵ�out.jsp�У�����session
   (session.invalidate())
 * */
public class MyListener03 implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("session������");
		long start = System.currentTimeMillis();
		se.getSession().setAttribute("start",start);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		System.out.println("session������");
		long end = System.currentTimeMillis();
		long start = (Long) se.getSession().getAttribute("start");
		long time = end - start;
		System.out.println("start====="+start+"		end===="+end);
		System.out.println("sessionʱ��"+time/60+"��");
	}
		
}
