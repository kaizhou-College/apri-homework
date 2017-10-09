package filter;

import java.io.IOException;
import java.io.InputStream;
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


public class filter_04 implements Filter {
	private Properties ps=null;
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)arg0;
		Enumeration names = request.getParameterNames();
		while(names.hasMoreElements()){
			String key =(String)names.nextElement();
			String[] values = request.getParameterValues(key);
			for (int i = 0; i < values.length; i++) {
				if(ps.getProperty(values[i])!=null){
					values[i]=ps.getProperty(values[i]);
				}
			}
			
		}
		
		arg2.doFilter(arg0, arg1);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		ps=new Properties();
		InputStream inputStream = arg0.getServletContext().getResourceAsStream("WEB-INF/str.properties");
		
		try {
			ps.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
}

}
