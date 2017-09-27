package workFour;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener{
	private Properties ps;
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContext application = sce.getServletContext();
		ps = new Properties();
		int count = (Integer) application.getAttribute("count");
		int all = (Integer)application.getAttribute("all");
		ps.setProperty("count",count+"");
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

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ps = new Properties();
		ServletContext application = sce.getServletContext();
		InputStream in = application.getResourceAsStream("/WEB-INF/count.properties");
		try {
			ps.load(in);
			//获取请求次数和访问量
			String count = ps.getProperty("count");
			String all = ps.getProperty("all");
			UserInfo.setCount(0);
			//将人数放到application对象
			application.setAttribute("count", Integer.parseInt(count));
			application.setAttribute("all", Integer.parseInt(all));
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
