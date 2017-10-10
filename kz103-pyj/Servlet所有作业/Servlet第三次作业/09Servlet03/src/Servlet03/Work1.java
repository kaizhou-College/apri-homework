package Servlet03;
//写一个例子，测试filter和servlet的生命周期
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class Work1 implements Filter{
	public void Work1(){
		System.out.println("Work1被创建");
	}
	public void destroy() {
		System.out.println("Work1被销毁");
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("Work1在执行检查");
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Work1初始化");
	}



}
