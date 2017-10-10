package filter;

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

public class filter_03 implements Filter {
	public filter_03() {
		// TODO Auto-generated constructor stub
		System.out.println("filter_03被创建了");
	}
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		HttpSession session=request.getSession();
		System.out.println("222"+session.getAttribute("name").toString().length()+"111");
		if(session.getAttribute("name").toString().length()==0){
			response.sendRedirect("../zy_03.jsp");
			return;
		}
		System.out.println("filter_03门卫");
		arg2.doFilter(arg0, arg1);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
