package filter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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

import action.Action;
import action.impl.ActionForward;

public class Filters implements Filter{
	private Properties ps;
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse responce,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) responce;
		String method = req.getMethod();
		//���б���
		if(method.equalsIgnoreCase("post")){
			request.setCharacterEncoding("UTF-8");
		}else{
			Enumeration names = request.getParameterNames();
			while(names.hasMoreElements()){
				String key = (String) names.nextElement();
				String[] values = request.getParameterValues(key);
				for (int i = 0; i < values.length; i++) {
					values[i]=new String(values[i].getBytes("iso-8859-1"),"UTF-8");
				}
			}
		}
		String uri=req.getRequestURI();//����ȥ��Ŀ������ʲô
		File file=new File(uri);//��ȡҵ��Ա.action
		String name = file.getName();
		System.out.println("name======="+name);
		//��ʼ���񣬲�֪����ʲôҵ��Ա
		String actionName = ps.getProperty(name); 
		System.out.println("actionName======="+actionName);
		try {
			Class actionClazz = Class.forName(actionName);
			Action action = (Action) actionClazz.newInstance();
			ActionForward af = action.execute(req, res);
			//�ѽ�����ؿ����ض�����ת��
			if(af.isFlag()){
				//�ض���
				res.sendRedirect(af.getUrl()+".jsp");
			}else{
				//ת��
				req.getRequestDispatcher(af.getUrl()+".jsp").forward(req, res);
			}
			return;//��������
		} catch (Exception e) {
			e.printStackTrace();
		}
		//����
		chain.doFilter(request, responce);
	}
	public void init(FilterConfig config) throws ServletException {
		ps=new Properties();
		InputStream in=config.getServletContext().getResourceAsStream("WEB-INF/actionConfig.properties");
		try {
			ps.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
