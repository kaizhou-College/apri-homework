package com.kz.ActionFilter;

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

import com.kz.Action.Action;
import com.kz.entity.ActionForward;

public class ActionServlet implements Filter{
	private Properties ps;
	public void destroy() {
		System.out.println("ActionServlet出生啦...");
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
		FilterChain arg2) throws IOException, ServletException {
			System.out.println("ActionServlet在服务呢1");
			HttpServletRequest req=(HttpServletRequest)arg0;
			HttpServletResponse res=(HttpServletResponse)arg1;
			//决绝编码问题////////
			res.setContentType("text/html;charset=utf-8");
			String method = req.getMethod();
			if(method.equalsIgnoreCase("post")){
				req.setCharacterEncoding("utf-8");
			}else{
				Enumeration names = req.getParameterNames();
				while (names.hasMoreElements()) {
					String key = (String) names.nextElement();
					String[] values = req.getParameterValues(key);
					for (int i = 0; i < values.length; i++) {
						values[i]=new String(values[i].getBytes("iso-8859-1"),"utf-8");
					}
				}
			}
			//跳跳000000000
			StringBuffer url = req.getRequestURL();
			File file=new File(url.toString());
			String name = file.getName();
			System.out.println(name+"==name");
			String property = ps.getProperty(name);
			System.out.println(property+"====pro  ");
			try {
				Class forName = Class.forName(property);
				Action newInstance = (Action) forName.newInstance();
				ActionForward execute = newInstance.execute(req,res);
				if(execute.isBool()){
					req.getRequestDispatcher(execute.getUrl()).forward(req,res);
				}else{
					res.sendRedirect(execute.getUrl());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	public void init(FilterConfig arg0) throws ServletException {
		ps=new Properties();
		InputStream in = arg0.getServletContext().getResourceAsStream("/WEB-INF/actionConfig.properties");
		try {
			ps.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
