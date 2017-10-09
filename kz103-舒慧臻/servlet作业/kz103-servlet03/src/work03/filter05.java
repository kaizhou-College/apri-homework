package work03;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
/**
 * 5.дһ��jsp�������ı��򣬷ֱ���д������סַ��������λ,
 * ��post��ʽ�ύ��StrServlet(�̳�GenericServlet),
 * ��web-inf׼��һ��str.properties�ļ�  �ļ�����: ������ = **  (����) 
 * ���� = ***    (סַ)            
 * �����鱨��=****  (������λ)  
 * дһ��Filter,��init()��ȡstr.properties����,
 * ��doFilter()���г����б���ֵ������г��������е��ַ��ͽ����滻,  
 * ����֮����StrServlet���õ�����,��ӡ������ͻ���
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
			//��ȡ���������
			Enumeration names = request.getParameterNames();
			while(names.hasMoreElements()){
				String key = (String)names.nextElement();
				String[] values = request.getParameterValues(key);
				//�ж��Ƿ��зǷ��ַ�
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
		//��ȡ�Ƿ��ַ��ļ�
		ps = new Properties();
		InputStream inputStream = filterConfig.getServletContext().getResourceAsStream("/WEB-INF/str.properties");
		try {
			ps.load(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
