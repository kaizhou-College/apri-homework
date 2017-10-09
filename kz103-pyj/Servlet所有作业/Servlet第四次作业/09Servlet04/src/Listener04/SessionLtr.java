package Listener04;
/*����һ���û���¼��ʱ�䣺
   дһ��SessionLtr��(�̳�HttpSessionListener)������session���������٣���
   sessionCreated�����еõ�ϵͳ�ĵ�ǰʱ�䣬Ȼ�����õ�HttpSession�����У������ͼ�¼��
   ��¼�Ŀ�ʼʱ�䣬Ȼ����sessionDestroyed������ͬ���ٵõ�ϵͳ�ĵ�ǰʱ�䣬Ȼ���HttpSession����
   ���ó���ʼʱ�䣬Ȼ�����ʱ����ӡ��������̨ 
   ����index.jsp����ʼ����Session����index.jsp���и�������"�˳�",�����ӵ�out.jsp�У�����session
   (session.invalidate())*/
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionLtr implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent hse) {
		System.out.println("session������....");
		long denglu = System.currentTimeMillis();
		HttpSession httpSession = hse.getSession();
		httpSession.setAttribute("denglu", denglu);
	}

	public void sessionDestroyed(HttpSessionEvent hse) {
		System.out.println("session������....");
		long xitong = System.currentTimeMillis();
		HttpSession httpSession = hse.getSession();
		long time =(Long)httpSession.getAttribute("denglu");
		long cha=time-xitong;
		System.out.println("ʱ�����"+cha);

	}

}
