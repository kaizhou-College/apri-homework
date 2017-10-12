package com.kqw;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class applicationLtr implements ServletContextListener {
	
	private Properties ps;
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext application = sce.getServletContext();
		ps=new Properties();
		//count���������
		int count = (Integer) application.getAttribute("count");
		//all�Ƿ�����
		int all = (Integer) application.getAttribute("all");
		//������������������ŵ�properties��
		ps.setProperty("count", count+"");
		ps.setProperty("all", all+"");
		String path=application.getRealPath("/WEB-INF/math.properties");
		FileOutputStream fos=null;
		PrintStream out=null;
		try {
			fos=new FileOutputStream(path);
			out=new PrintStream(fos);
			ps.list(out);
			fos.close();
			out.close();
		} catch (FileNotFoundException e) {
	
			e.printStackTrace();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
	}
	//�ڴ�����ʱ����ı��ĵ��л��ߴ����ݿ��ж�ȡ����
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ps=new Properties();
		ServletContext application = sce.getServletContext();
		InputStream in = application.getResourceAsStream("/WEB-INF/math.properties");
		try {
			ps.load(in);
			
			 String all = ps.getProperty("all");
			 String count = ps.getProperty("count");
			
			application.setAttribute("all",Integer.parseInt(all));
			
			application.setAttribute("count", Integer.parseInt(count));
		
			//����������ʼ��
			application.setAttribute("onLine", 0);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
