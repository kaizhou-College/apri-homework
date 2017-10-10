package filter;

import java.io 

.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class doFilter implements Filter {
	public doFilter() {
		// TODO Auto-generated constructor stub
		System.out.println("doFilter被创建了");
	}
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		HttpSession session=request.getSession();
		System.out.println(session.getAttribute("name").toString().length());
		if(session.getAttribute("name").toString().length()==0){
			response.sendRedirect("/save/save.jsp");
			return;
		}
		System.out.println("门卫在工作");
		chain.doFilter(req, res);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
