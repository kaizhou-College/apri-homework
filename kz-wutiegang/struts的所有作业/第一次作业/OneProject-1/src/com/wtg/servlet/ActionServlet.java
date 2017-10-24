package com.wtg.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wtg.Action.Action;
import com.wtg.Action.ActionForward;


public class ActionServlet extends GenericServlet{
	private Properties ps=null;
	@Override
	//��ȡProperties�ļ����������
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		ps=new Properties();
		InputStream in = config.getServletContext().getResourceAsStream("/WEB-INF/actionConfig.properties");
		
		try {
			ps.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) res;
		//�õ������ַ��uri
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		//����uri�õ�������
		File file=new File(uri);
		String name = file.getName();
		//���ݷ�������properties�ļ��еõ�ֵ(ҵ��Ա����)
		String property = ps.getProperty(name);
		//����ֵ�õ�������ֽ���
		try {
			Class clazz = Class.forName(property);
			//��������
			Action action = (Action) clazz.newInstance();
			//�õ�����
			ActionForward excute = action.excute(request, response);
			String url = excute.getUrl();
			boolean redirect = excute.isRedirect();
			if (redirect) {
				response.sendRedirect(url);
			}else{
				request.getRequestDispatcher(url).forward(request, response);
			}
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
		
	}
	


}
