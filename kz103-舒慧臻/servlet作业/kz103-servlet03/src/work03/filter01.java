package work03;
/**
 * 1.写一个例子，测试filter和servlet的生命周期
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class filter01 implements Filter {

	public filter01(){
		System.out.println("过滤器被创建了");
	}
	@Override
	public void destroy() {
		System.out.println("过滤器被销毁了");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			System.out.println("门卫在执行检查……");
			//放行
			chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器初始化了");
	}

}
