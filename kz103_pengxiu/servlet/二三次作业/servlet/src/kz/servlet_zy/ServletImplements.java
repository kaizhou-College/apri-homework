package kz.servlet_zy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class ServletImplements implements Servlet{
	private ServletConfig config;
	private ServletConfig ServletConfig;
	public ServletImplements(){
		
		System.out.println("创建ServletImplements");
	}
	public void destroy() {
		System.out.println("销毁一般用于收尾");
		
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.ServletConfig;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return this.getServletInfo()+"ServletImplements用来测试声明周期的";
	}

	public void init(ServletConfig config) throws ServletException {
		this.config=config;
		
	}

	public void service(ServletRequest re, ServletResponse rq)
			throws ServletException, IOException {
		//out在servlet里面不是内置对象所以要创建
		PrintWriter a=rq.getWriter();
		//获取method提交方式
		HttpServletRequest request=(HttpServletRequest)re;
		String method = request.getMethod();
		//获取servlet的编码配置
		String encode = config.getInitParameter("encode");	
		String parameter = null;
		if(method.equalsIgnoreCase("post")){
			re.setCharacterEncoding(encode);
			parameter=re.getParameter("zy");
		}else{
			parameter=re.getParameter("zy");
			parameter=new String(parameter.getBytes("iso-8859-1"),"utf-8");
		}
		
		
		
		
		
		//网页输出歌词
		a.print(parameter);
		
	}

}
