package workFour;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		
	
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		ServletContext application = sre.getServletContext();
		Object obj = application.getAttribute("count");
		int count=0;
		if(obj==null){
			count=0;
		}else{
			count = (Integer) obj;
		}
		count++;
		application.setAttribute("count",count);
		//��Ϊ����session�󶨷���������һ������֮�����ˢ��һ�ο����������session�ļ��������ݾͻ�һֱ����
		
	}

}
