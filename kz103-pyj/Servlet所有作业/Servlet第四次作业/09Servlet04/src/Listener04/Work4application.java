package Listener04;
//4.ͳ����������������������ͷ��ʵ�������
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Work4application implements ServletContextListener{
	private Properties ps;
	//���application�����ˣ���ô�������ͷ��ʴ�����Ҫ���������ݿ�����ļ���
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("work4��application������");
		ServletContext application = sce.getServletContext();
		ps=new Properties();
		//�Ȼ�ȡ����Ĵ����ͷ�����
		int count=(Integer)application.getAttribute("count");
		int cishu=(Integer)application.getAttribute("cishu");
		//����ps���������
		ps.setProperty("count", count+"");
		ps.setProperty("cishu", cishu+"");
		FileOutputStream fos=null;
		PrintStream prs=null;
		try {
			String path=application.getRealPath("/WEB-INF/work4.properties");
			fos=new FileOutputStream(path);
			prs=new PrintStream(fos);
			ps.list(prs);
			fos.close();
			prs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//application�����˵Ļ���Ҫ��ȡ���������ݿ�����ļ��е�����
	public void contextInitialized(ServletContextEvent sce) {
		ps=new Properties();
		ServletContext application = sce.getServletContext();
		InputStream inputStream = application.getResourceAsStream("/WEB-INF/work4.properties");
		try {
			ps.load(inputStream);
			//��ȡ��������
			String count=ps.getProperty("count");
			String cishu=ps.getProperty("cishu");
			//�����ݷŵ�application��
			application.setAttribute("count", Integer.parseInt(count));
			application.setAttribute("cishu", Integer.parseInt(cishu));
			//���ʼ����Ϊ1
			application.setAttribute("start", 1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				inputStream.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
