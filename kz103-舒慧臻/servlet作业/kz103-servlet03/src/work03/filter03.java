package work03;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class filter03 implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			HttpSession session = req.getSession();
			String user = (String)session.getAttribute("user");
			//String pswd = (String)session.getAttribute("pswd");
			if(user == null||!user.equals("login")){
				res.sendRedirect(req.getContextPath()+"/save/save02.jsp");
				return;
			}else{
				chain.doFilter(request, response);
			}
			
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

}
