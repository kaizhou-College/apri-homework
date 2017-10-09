package Servlet03;
//写一个filter过滤请求遍历所有的值，如果有为null，就给它一个空字符串，
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Work4Filter implements Filter {
	public void destroy() {
	}
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
			HttpServletRequest request=(HttpServletRequest) req;
			HttpServletResponse response=(HttpServletResponse) res;
			Enumeration enumeration = request.getParameterNames();
			while(enumeration.hasMoreElements()){
				String key=(String) enumeration.nextElement();
				String values=request.getHeader(key);
					if(values==null){
						values=" ";
				}
			}
			chain.doFilter(request, response);
	}
	public void init(FilterConfig arg0) throws ServletException {
	}
}
