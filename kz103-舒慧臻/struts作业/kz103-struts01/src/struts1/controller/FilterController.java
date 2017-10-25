package struts1.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import struts1.action.Action;
import struts1.action.impl.ActionForward;

public class FilterController implements Filter {
	private Properties ps;

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			//强制转换
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			//1.需要知道那个教授看什么科？配置文件的方式 .properties
			//在ActionServlet的服务方法中根据请求的URI得到对应的业务员对象。
			String uri = req.getRequestURI();
			File file = new File(uri);
			String name = file.getName();
			System.out.println("name======="+name);
			//调用业务员的execute方法
			String property = ps.getProperty(name);
			System.out.println("property======"+property);
			try {
				Class clazz = Class.forName(property);
				Action action = (Action) clazz.newInstance();
				//开始工作并接收业务员返回的结果页面的对象ActionForward
				ActionForward af = action.excute(req, res);
				//接收到业务员返回的结果页面后，将根据ActionForward的boolean类型属性，
				//将页面转发或者是重定向到结果页面去。
				if(af.isRedirect()){//默认转发
					req.getRequestDispatcher(af.getUrl()+".jsp").forward(req, res);
				}else{
					res.sendRedirect(af.getUrl()+".jsp");
				}
				return ;//结束请求
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			chain.doFilter(req, res);
	}
/*只会调用一次，如果是在doFilter中写的话，配置一次就会调用一次，而我们只需要读取
 * 配置中的内容一次
 */
	public void init(FilterConfig config) throws ServletException {
		//在init方法中将属性文件actionConfig.properties文件内容加载到一个属性对象中。
		ps = new Properties();
		InputStream inputStream = config.getServletContext().getResourceAsStream("/WEB-INF/actionConfig.properties");
		try {
			ps.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
