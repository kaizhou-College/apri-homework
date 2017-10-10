package com.kz.L1;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
//抽象=====不完整  Object类祖先类
//单列
public  class MyServlet01 implements Servlet {
	private ServletConfig config;
	public MyServlet01() {
		System.out.println("servlet出生了");
	}
	@Override
	public void destroy() {
		System.out.println("servlet销毁了");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("servlet初始化了");
		this.config = config;
		
	}
	
	int i ;
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		HttpServletRequest requeset =(HttpServletRequest) req;
		i++;
		System.out.println("服务"+i+"次");
		//res.setContentType("utf-8");
		String encode = this.config.getInitParameter("encode");
		System.out.println("encode==="+encode);
		res.setContentType("text/html;charset="+encode);
		requeset.getSession();
	}
	
}


//不针对任何协议
/*public class MyServlet01 extends GenericServlet{
	
	
	@Override
	public void init() throws ServletException {
		//你自己的特殊初始化
		
	}
	int i ;
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//没有区分请求方式：post  get  head .......
		i++;
		System.out.println("服务"+i+"次");
	}
	
}*/
/*public class MyServlet01 extends HttpServlet{
	int i;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		i++;
		System.out.println("服务"+i+"次");
	}
	

}*/

