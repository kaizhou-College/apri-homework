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

public class Myfilter05 implements Filter {
	private Properties ps = null;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		Enumeration enumeration = req.getParameterNames();
		while(enumeration.hasMoreElements()){
			String key = (String) enumeration.nextElement();
			String[] values = req.getParameterValues(key);
			for (int i = 0; i < values.length; i++) {
				if(ps.getProperty(values[i])!=null){
					values[i] = ps.getProperty(values[i]);
				}
			}
		}
		
		
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig filter) throws ServletException {
		// TODO Auto-generated method stub
			ps = new Properties();
			InputStream inputStream = filter.getServletContext().getResourceAsStream("WEB-INF/str.properties");
			try {
				ps.load(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
