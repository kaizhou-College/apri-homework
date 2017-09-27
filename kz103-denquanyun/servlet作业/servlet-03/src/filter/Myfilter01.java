package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/*
 *1.写一个例子，测试filter和servlet的生命周期
 * */
public class Myfilter01 implements Filter {

	public Myfilter01(){
		System.out.println("Myfilter01出生了");
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Myfilter01销毁了");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Myfilter01检查检查");
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Myfilter01初始化");
	}


}
