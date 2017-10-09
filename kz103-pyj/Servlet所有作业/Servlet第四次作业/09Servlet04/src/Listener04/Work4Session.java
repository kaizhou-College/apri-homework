package Listener04;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Work4Session implements HttpSessionListener{

	public void sessionCreated(HttpSessionEvent hse) {
		//��ȡԭ����application�б���������ͷ��ʴ���
		ServletContext application = hse.getSession().getServletContext();
		Object object = application.getAttribute("start");
		int start=0;
		if(object==null){
			start=0;
		}else{
			start=(Integer)object;
		}
		object=application.getAttribute("cishu");
		int cishu=0;
		if(object==null){
			cishu=0;
		}else{
			cishu=(Integer)object;
		}
		//��ԭ�����ʵĴ�������������+1
		cishu++;
		start++;
		//��󱣳��µ������ͷ��ʴ���
		application.setAttribute("start", start);
		application.setAttribute("cishu", cishu);
	}
//����˳���ô����������-1
	public void sessionDestroyed(HttpSessionEvent hse) {
		//�Ȼ�ȡԭ������������
		ServletContext application = hse.getSession().getServletContext();
		Object object = application.getAttribute("start");
		int start=0;
		if(object==null){
			start=0;
		}else{
			start=(Integer)object;
			//Ȼ����ԭ���Ļ���-1
			start--;
		}
		//��󱣳��µ���������
		application.setAttribute("start", start);
	}

}
