package struts1.controller;

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

public class FilterEcondeing implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			String method = req.getMethod();
			if(method.equalsIgnoreCase("post")){
				req.setCharacterEncoding("utf-8");
			}else if(method.equalsIgnoreCase("get")){
				//先用枚举得到所有的值
				Enumeration names = req.getParameterNames();
				while(names.hasMoreElements()){
					String key = (String) names.nextElement();
					String[] values = req.getParameterValues(key);
					for (int i = 0; i < values.length; i++) {
						values[i] = new String(values[i].getBytes("iso-8859-1"),"utf-8"); 
					}
					
				}
			}
			//响应编码
			res.setContentType("text/html;charset=utf-8");
			//放行
			chain.doFilter(req, res);
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
