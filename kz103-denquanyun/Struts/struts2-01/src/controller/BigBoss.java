package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actions.Action;
import actions.impl.ActionForward;

public class BigBoss implements Filter {
	private Properties pro;
	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req1 = (HttpServletRequest) req;
		HttpServletResponse resp1 = (HttpServletResponse) resp;
		String method = req1.getMethod();
		//进行编码
		if(method.equalsIgnoreCase("post")){
			req1.setCharacterEncoding("UTF-8");
		}else{
			Enumeration names = req1.getParameterNames();
			while(names.hasMoreElements()){
				String key = (String) names.nextElement();
				String[] values = req1.getParameterValues(key);
				for (int i = 0; i < values.length; i++) {
					values[i]=new String(values[i].getBytes("iso-8859-1"),"UTF-8");
				}
			}
		}
/////////////////////////////////////////		
		String uri = req1.getRequestURI();
		File file = new File(uri);
		String key = file.getName();
//		System.out.println(key);
		String value = pro.getProperty(key);
//		System.out.println(value);
		try {
			Class clazz = Class.forName(value);
			Action action = (Action) clazz.newInstance();
			ActionForward result = action.execute(req1,resp1);
//			req1.getRequestDispatcher(result.getUri()+".jsp").forward(req1, resp1);
			if(result.isFalg()){
				resp1.sendRedirect(result.getUri()+".jsp");
			}else{
				req1.getRequestDispatcher(result.getUri()+".jsp").forward(req1, resp1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//(5)在ActionServlet类的init方法中将属性文件actionConfig.properties文件内容加载到一个属性对象中。
	public void init(FilterConfig filterconfig) throws ServletException {
		//初始化业务员
		pro = new Properties();
		InputStream in = filterconfig.getServletContext().getResourceAsStream("/WEB-INF/menu.properties");
		try {
			pro.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
