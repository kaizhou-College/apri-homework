package Listener04;
//4.统计在线人数，请求次数，和访问的总人数
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Work4application implements ServletContextListener{
	private Properties ps;
	//如果application销毁了，那么访问量和访问次数就要保存在数据库或者文件中
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("work4的application销毁了");
		ServletContext application = sce.getServletContext();
		ps=new Properties();
		//先获取请求的次数和访问量
		int count=(Integer)application.getAttribute("count");
		int cishu=(Integer)application.getAttribute("cishu");
		//在往ps中添加数据
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
//application创建了的话就要读取保存在数据库或者文件中的数据
	public void contextInitialized(ServletContextEvent sce) {
		ps=new Properties();
		ServletContext application = sce.getServletContext();
		InputStream inputStream = application.getResourceAsStream("/WEB-INF/work4.properties");
		try {
			ps.load(inputStream);
			//获取请求数据
			String count=ps.getProperty("count");
			String cishu=ps.getProperty("cishu");
			//把数据放到application中
			application.setAttribute("count", Integer.parseInt(count));
			application.setAttribute("cishu", Integer.parseInt(cishu));
			//设初始人数为1
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
