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
/*,׼��һ�������������˵���/save/save.jsp����������doFilter()�м��session�����ֵ�Ƿ�Ϊ�գ�
���Ϊ�գ��ض��򵽵�¼ҳ�档ע��:filter���á�*/
public class SaveFilter implements Filter{
	public void destroy() {
	}
	//Ȩ�޹���
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
