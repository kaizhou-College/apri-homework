package work03;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
/**
 * 5.写一个jsp，三个文本框，分别填写姓名，住址，工作单位,
 * 以post方式提交到StrServlet(继承GenericServlet),
 * 在web-inf准备一个str.properties文件  文件内容: 二狗子 = **  (姓名) 
 * 地狱 = ***    (住址)            
 * 中央情报局=****  (工作单位)  
 * 写一个Filter,在init()读取str.properties内容,
 * 在doFilter()中列出所有表单的值，如果有出现上述中的字符就进行替换,  
 * 过滤之后，在StrServlet中拿到数据,打印输出到客户端
 */
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class filter05 implements Filter {
	private Properties ps = null;
	@Override
	public void destroy() {
		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			//获取聊天的内容
			Enumeration names = request.getParameterNames();
			while(names.hasMoreElements()){
				String key = (String)names.nextElement();
				String[] values = request.getParameterValues(key);
				//判断是否有非法字符
				for (int i = 0; i < values.length; i++) {
					if(ps.getProperty(values[i])!=null){
						values[i] = ps.getProperty(values[i]);
					}
				}
				
			}
			chain.doFilter(request, response);
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//读取非法字符文件
		ps = new Properties();
		InputStream inputStream = filterConfig.getServletContext().getResourceAsStream("/WEB-INF/str.properties");
		try {
			ps.load(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
