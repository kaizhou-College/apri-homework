package filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ZY_02 implements Filter {
	public ZY_02(){
		System.out.println("zy——2被创建了");
	}
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("zy_2被创建了");
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		System.out.println("zy_02正介绍检查");
		
		arg2.doFilter(arg0,arg1);
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("zy_2更新了");
	}

}
