package com.wtg.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wtg.Action.Action;
import com.wtg.Action.ActionForward;


public class ActionServlet extends GenericServlet{
	private Properties ps=null;
	@Override
	//读取Properties文件里面的内容
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		ps=new Properties();
		InputStream in = config.getServletContext().getResourceAsStream("/WEB-INF/actionConfig.properties");
		
		try {
			ps.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) res;
		//得到请求地址的uri
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		//根据uri得到方法名
		File file=new File(uri);
		String name = file.getName();
		//根据方法名在properties文件中得到值(业务员对象)
		String property = ps.getProperty(name);
		//根据值拿到对象的字节码
		try {
			Class clazz = Class.forName(property);
			//创建对象
			Action action = (Action) clazz.newInstance();
			//拿到方法
			ActionForward excute = action.excute(request, response);
			String url = excute.getUrl();
			boolean redirect = excute.isRedirect();
			if (redirect) {
				response.sendRedirect(url);
			}else{
				request.getRequestDispatcher(url).forward(request, response);
			}
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
		
	}
	


}
