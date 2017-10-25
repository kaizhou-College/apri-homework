package struts1.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import struts1.action.Action;
import struts1.action.impl.ActionForward;

public class FilterController implements Filter {
	private Properties ps;

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			//ǿ��ת��
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			//1.��Ҫ֪���Ǹ����ڿ�ʲô�ƣ������ļ��ķ�ʽ .properties
			//��ActionServlet�ķ��񷽷��и��������URI�õ���Ӧ��ҵ��Ա����
			String uri = req.getRequestURI();
			File file = new File(uri);
			String name = file.getName();
			System.out.println("name======="+name);
			//����ҵ��Ա��execute����
			String property = ps.getProperty(name);
			System.out.println("property======"+property);
			try {
				Class clazz = Class.forName(property);
				Action action = (Action) clazz.newInstance();
				//��ʼ����������ҵ��Ա���صĽ��ҳ��Ķ���ActionForward
				ActionForward af = action.excute(req, res);
				//���յ�ҵ��Ա���صĽ��ҳ��󣬽�����ActionForward��boolean�������ԣ�
				//��ҳ��ת���������ض��򵽽��ҳ��ȥ��
				if(af.isRedirect()){//Ĭ��ת��
					req.getRequestDispatcher(af.getUrl()+".jsp").forward(req, res);
				}else{
					res.sendRedirect(af.getUrl()+".jsp");
				}
				return ;//��������
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			chain.doFilter(req, res);
	}
/*ֻ�����һ�Σ��������doFilter��д�Ļ�������һ�ξͻ����һ�Σ�������ֻ��Ҫ��ȡ
 * �����е�����һ��
 */
	public void init(FilterConfig config) throws ServletException {
		//��init�����н������ļ�actionConfig.properties�ļ����ݼ��ص�һ�����Զ����С�
		ps = new Properties();
		InputStream inputStream = config.getServletContext().getResourceAsStream("/WEB-INF/actionConfig.properties");
		try {
			ps.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
