package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class filter_01 implements Filter {
	public filter_01() {
		// TODO Auto-generated constructor stub
		System.out.println("filter_01被创建了");
	}
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("filter_01被销毁了");
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("filter_01 正在接受检查");
		arg2.doFilter(arg0, arg1);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("filter_01被更新了");
	}



}
