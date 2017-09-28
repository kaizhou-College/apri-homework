package com.kz.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener {
	
	private Properties ps ;
	//application����----web���ڴ�������
	///---application������(������������������������ݿ⣬�ļ�)
	//---application������(��ȡ���������ݿ�����ļ��еķ��������������)
	
	//application������(������������������������ݿ⣬�ļ�)
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("application������222222....");
		ServletContext application = sce.getServletContext();
		ps = new Properties();
		//1,��ȡ��������ͷ�����
		int count = (Integer) application.getAttribute("count");
		int all = (Integer)application.getAttribute("all");
		//��ps���������
		ps.setProperty("count", count+"");
		ps.setProperty("all",all+"");
		FileOutputStream fos = null;
		PrintStream out = null;
		try {
			String path = application.getRealPath("/WEB-INF/count.properties");
			
			fos = new FileOutputStream(path);
			out = new PrintStream(fos);
			ps.list(out);
			fos.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//application������(��ȡ���������ݿ�����ļ��еķ��������������)
	public void contextInitialized(ServletContextEvent sce) {
		ps = new Properties();
		ServletContext application = sce.getServletContext();
		InputStream in = application.getResourceAsStream("/WEB-INF/count.properties");
		try {
			ps.load(in);
			//��ȡ��������ͷ�����
			String count = ps.getProperty("count");
			String all = ps.getProperty("all");
			//�������ŵ�application����
			application.setAttribute("count", Integer.parseInt(count));
			application.setAttribute("all", Integer.parseInt(all));
			//����������ʼֵ��1
			application.setAttribute("onLine", 1);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
