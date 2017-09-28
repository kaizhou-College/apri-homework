package Servlet01;

/**
 * 3.写一个类实现Servlet接口,统计此servlet被请求了多少次，
 * 输出到客户端,在销毁此Servlet的时候，将请求次数写到
 *硬盘的文本文档中.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet3 implements Servlet {
	private int i = 0;
	private ServletConfig servletConfig;
	public Servlet3() {
		System.out.println("servlet被创建了");
	}
	public void destroy() {
		//销毁
		System.out.println("Servlet3被销毁了");
		File file = new File("E:/a.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			fw.write(""+this.i);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(fw!=null){
					fw.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	public void init() throws ServletException {
		
	}
	public ServletConfig getServletConfig() {
		return this.getServletConfig();
	}
	public String getServletInfo() {
		return "测试servletwork03	的声明周期的方法";
	}
	public void init(ServletConfig config) throws ServletException {
		System.out.println("初始化开始");
		this.servletConfig = config;
	}

	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			i=i+1;
			out.print("服务一次"+i+"次");
	}

}