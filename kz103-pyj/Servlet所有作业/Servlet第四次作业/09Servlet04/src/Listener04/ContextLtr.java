package Listener04;
/*������Ŀ������ʱ�䣺
   дһ��ContextLtr��(�̳�ServletContextListener)������ServletContext�Ĵ��������٣���
   contextInitialized�����еõ�ϵͳ�ĵ�ǰʱ�䣬Ȼ�����õ�ServletContext�����У������ͼ�¼��
   ��Ŀ�����Ŀ�ʼʱ�䣬Ȼ����contextDestroyed������ͬ���ٵõ�ϵͳ�ĵ�ǰʱ�䣬Ȼ��ServletContext����
   ���ó���ʼʱ�䣬Ȼ�����ʱ�����ļ��������ʱ��������һ���ļ���.

   ������tomcat,��һ����ʱ��ر�tomcat��*/
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLtr implements ServletContextListener{
	private Properties ps;
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("context������...");
		long newtime = System.currentTimeMillis();//contextDestroyedϵͳ��ǰʱ��
		ServletContext servletContext = sce.getServletContext();
		long getold =(Long) servletContext.getAttribute("oldtime");
		long getchacha=newtime-getold;
		System.out.println("��ҵ2��ʱ�����"+getchacha+"����");
		//��ȡʱ���
		int getcha=(Integer)servletContext.getAttribute("cha");
		//��ps���������
		ps.setProperty("getcha", getcha+"");
		FileOutputStream fos=null;
		PrintStream out=null;
		try {
			String path=servletContext.getRealPath("/WEB-INF/work2.properties");
			fos=new FileOutputStream(path);
			out=new PrintStream(fos);
			fos.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("context������...");
		long oldtime = System.currentTimeMillis();//contextInitializedϵͳ��ǰʱ��
		ServletContext servletContext = sce.getServletContext();
		servletContext.setAttribute("oldtime", oldtime);
		ps=new Properties();
		InputStream in = servletContext.getResourceAsStream("/WEB-INF/work2.properties");
		try {
			ps.load(in);
			//��ȡʱ���
			String getcha=ps.getProperty("getcha");
			//��ʱ���ŵ�servletContext����
			servletContext.setAttribute("getcha", getcha);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
