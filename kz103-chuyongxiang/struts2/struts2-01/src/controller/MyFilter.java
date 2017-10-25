package controller;

import impl.ActionForward;

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

import action.Action;


public class MyFilter implements Filter{
	private Properties ps;

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest) request;//强转类型
		HttpServletResponse res=(HttpServletResponse) response;//强转类型
		String uri=req.getRequestURI();//获取uri地址
		File file=new File(uri);//把uri作为文件
		String bing=file.getName();//获取文件的属性名字
		System.out.println("得到的是"+bing);
		String actionname=ps.getProperty(bing);//从自建的文件里查询属性名
		System.out.println("actionname"+actionname);
		try {
			Class actionclazz=Class.forName(actionname);//从Class文件中获取
			Action action=(Action) actionclazz.newInstance();//new一个接口的方法
			ActionForward af=action.execute(req, res);
			if(af.isRedirect()){//判断是重定向还是转发方式
				System.out.println(af);
				res.sendRedirect(af.getUri()+".jsp");//重定向
			}else{
				req.getRequestDispatcher(af.getUri()+".jsp").forward(req,res);//转发
			}
			return;//结束请求
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		chain.doFilter(request, response);//放行
		
		
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		ps=new Properties();
		InputStream in=filterConfig.getServletContext().getResourceAsStream("/WEB-INF/actionConfig.properties");
		try {
			ps.load(in);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
