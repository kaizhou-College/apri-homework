package Listener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * 2.������Ŀ������ʱ�䣺

   дһ��ContextLtr��(�̳�ServletContextListener)������ServletContext�Ĵ��������٣���
   contextInitialized�����еõ�ϵͳ�ĵ�ǰʱ�䣬Ȼ�����õ�ServletContext�����У������ͼ�¼��
   ��Ŀ�����Ŀ�ʼʱ�䣬Ȼ����contextDestroyed������ͬ���ٵõ�ϵͳ�ĵ�ǰʱ�䣬Ȼ��ServletContext����
   ���ó���ʼʱ�䣬Ȼ�����ʱ�����ļ��������ʱ��������һ���ļ���.

   ������tomcat,��һ����ʱ��ر�tomcat��
 * */
public class MyListener02 implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("application������");
		long end = System.currentTimeMillis();
		ServletContext application = sce.getServletContext();
		long start = (Long) application.getAttribute("start");
		long time = end-start;
		System.out.println("start====="+start+"		end===="+end);
		System.out.println("ʱ��"+time/60+"��");
		File file = new File("D:/�Ҿ�/�����׶�/kz-103/servlet-04/readme.txt");
		try {
			FileWriter fw = new FileWriter(file);
			fw.write("ʱ���"+time/60+"��");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("application������");
		long start = System.currentTimeMillis();
		ServletContext application = sce.getServletContext();
		application.setAttribute("start",start);
	}

}
