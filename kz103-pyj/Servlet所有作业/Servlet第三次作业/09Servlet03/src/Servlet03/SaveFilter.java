package Servlet03;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*,准备一个过滤器，过滤掉“/save/save.jsp”的请求，在doFilter()中检查session里面的值是否为空，
如果为空，重定向到登录页面。注意:filter配置。*/
public class SaveFilter implements Filter{
	public void destroy() {
	}
	//权限过滤
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) res;
		String name=(String)request.getSession().getAttribute("name");
		String pwd=(String)request.getSession().getAttribute("pwd");
		//String path=request.getContextPath();
		if(name==null||!name.equals("admin")){
			response.sendRedirect(request.getContextPath()+"/save/work3-03.jsp");
			return;
		}else{
			chain.doFilter(request, response);
		}
	}
	public void init(FilterConfig arg0) throws ServletException {
	}
}
