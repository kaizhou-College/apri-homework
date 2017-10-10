package work03;

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

public class filter04 implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			Enumeration names = req.getParameterNames();
			while(names.hasMoreElements()){
				String key = (String) names.nextElement();
				String value = req.getHeader(key);
				if(value==null){
					value = " ";
				}
			}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
