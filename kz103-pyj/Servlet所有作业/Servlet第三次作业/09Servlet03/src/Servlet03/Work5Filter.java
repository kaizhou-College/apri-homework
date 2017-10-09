package Servlet03;

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
//写一个Filter,在init()读取str.properties内容,在doFilter()中列出所有表单的值，如果有出现上述中的字符就进行替换,
public class Work5Filter implements Filter {
	Properties ps = null;
	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain)
		throws IOException,ServletException {
		Enumeration enumeration = req.getParameterNames();
	      while(enumeration.hasMoreElements()){
	        String key = (String)enumeration.nextElement();
	        String[] values = req.getParameterValues(key);
	        for (int i = 0; i < values.length; i++) {       
	            //根据key,从properties中拿到值,如果不为空,则证明一定有非法字符
	            //然后替换掉
	             if(ps.get(values[i])!=null){
	                values[i] = ps.getProperty(values[i]);
	             }
	         }  
	       }
	       chain.doFilter(req, res);
	}
	public void init(FilterConfig filterConfig) throws ServletException {
	    try {
	            InputStream inputStream = filterConfig.getServletContext().getResourceAsStream("WEB-INF/str.properties");
	            ps = new Properties();
	            ps.load(inputStream);
	            inputStream.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	public void destroy() {
		
	}
	}
