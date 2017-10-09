package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class filter01 implements Filter{
	public filter01(){
		System.out.println("过滤器创建了");
	}

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("过滤器销毁了");
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤器在执行");
		chain.doFilter(req, res);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤器被初始化了");
	}

}
