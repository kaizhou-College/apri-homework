package com.kz.controller;

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

import com.kz.action.Action;
import com.kz.action.impl.ActionForward;
import com.kz.action.impl.ManAction;
//湘雅医院的服务大厅：挂号，服务
public class MyFilter implements Filter {
	private Properties ps;
	public void destroy() {

	}
	//过滤一次 调用一次
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//强转
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//挂号：
		//1.需要知道那个教授看什么科？配置文件的方式 .properties
		//init()-----web容器
		//2,知道患者要看什么科？
		//kz9struts2-01/man.action
		String uri = req.getRequestURI();
		//获取man.action 1）substring  2)File
		File file = new File(uri);
		String bing = file.getName();
		System.out.println("bing==="+bing);
		
		//3,开始服务(看病)
		//3.1找到医生
		String actionName = ps.getProperty(bing);
		System.out.println("action="+actionName);
		try {
			Class actionClazz = Class.forName(actionName);
			Action action = (Action) actionClazz.newInstance();
			//3.2调用医生看病
			//String re = action.excute();
			ActionForward af = action.excute(req,resp);
			//4,显示看病带回的结果(1,转发？ 2，重定向？)
			//默认就是转发
			//方式一
			/*if(re.contains("redirect:")){
				//重定向
				resp.sendRedirect(re.substring(re.indexOf(":")+1)+".jsp");
			}else{
				if(bing.contains("woman")){
					req.setAttribute("info","看妇科");
				}else{
					req.setAttribute("info","看男科");
				}
				//转发
				req.getRequestDispatcher(re+".jsp").forward(req, resp);
			}*/
			//方法二：
			if(af.isRedirect()){
				//重定向
				resp.sendRedirect(af.getUrl()+".jsp");
			}else{
				//转发
				req.getRequestDispatcher(af.getUrl()+".jsp").forward(req, resp);
			}
			
			return;//结束请求
		} catch (Exception e) {
			e.printStackTrace();
		}
		//放行
		chain.doFilter(request, response);
	}
	/*
	 * 只会调用一次(non-Javadoc)
	 * 读取配置文件只要读一次就够了。如果放到doFilter方法中
	 * 过滤一次，就会读取配置文件一次。
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		ps = new Properties();
		InputStream in = filterConfig.getServletContext().getResourceAsStream("/WEB-INF/menu.properties");
		try {
			ps.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
