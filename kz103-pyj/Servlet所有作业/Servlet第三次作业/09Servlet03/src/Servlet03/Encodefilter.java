package Servlet03;
/*2.写一个filter过滤请求解决
请求的中文乱码问题（get/post）和响应的中文乱码问题*/
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
public class Encodefilter implements Filter {

	public void destroy() {

	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String method = req.getMethod();
		if(method.equalsIgnoreCase("post")){
			req.setCharacterEncoding("utf-8");
		}else{
			Enumeration enumeration = req.getParameterNames();
			while(enumeration.hasMoreElements()){
				String key = (String) enumeration.nextElement();
				String[] values = req.getParameterValues(key);
				for(int i=0;i<values.length;i++){
					values[i] = new String(values[i].getBytes("iso-8859-1"),"utf-8");
				}
			}
		}
		res.setContentType("text/html;charset=utf-8");
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
