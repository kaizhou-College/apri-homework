package com.kz.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kz.action.Action;
import com.kz.action.ipml.AddUserAction;
import com.kz.action.ipml.Login;
import com.kz.dao.UserDao;
import com.kz.entity.ActionForward;
import com.kz.entity.Users;
//(1)����һ��ActionServlet����˾����Ҫ���ܹ��������е�.action���󡣣�������web.xml�ļ��ﵽҪ��
public class ActionServlet implements Filter{
	Properties ps;
	@Override
	public void destroy() {
		
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chan) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse reponse = (HttpServletResponse) res;
//		(6)��ActionServlet�ķ��񷽷����ȶ����е�����������б��롣
		String method = request.getMethod();
		if(method.equalsIgnoreCase("post")){
			req.setCharacterEncoding("utf-8");
		}else{
			Enumeration names = request.getParameterNames();
			if(names.hasMoreElements()){
				String key = (String) names.nextElement();
				String[] values = request.getParameterValues(key);
				for (int i = 0; i < values.length; i++) {
					values[i] = new String(values[i].getBytes("iso-8859-1"),"utf-8");
				}
			}
		}
		reponse.setContentType("text/html;charset=utf-8");
//		(7)��ActionServlet�ķ��񷽷��и��������URI�õ���Ӧ��ҵ��Ա����
		String uri = request.getRequestURI();
		File file = new File(uri);
		String key = file.getName();
		String className = ps.getProperty(key);
		ActionForward execute = null;
		System.out.println(key);
		try {
			Class cls = Class.forName(className);
			Action login = (Action) cls.newInstance();
			execute = login.execute(request, reponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(execute.isResponse()){
			reponse.sendRedirect(execute.getUri());
		}else{
			List<Users> user = UserDao.showUser();
			request.setAttribute("list", user);
			request.getRequestDispatcher(execute.getUri()).forward(request, reponse);
		}
		System.out.println("������");
		
	}
	@Override
	public void init(FilterConfig f) throws ServletException {
//		(5)��ActionServlet���init�����н������ļ�actionConfig.properties�ļ����ݼ��ص�һ�����Զ����С�
		System.out.println("��ʼ����");
		ps = new Properties();
		InputStream in = f.getServletContext().getResourceAsStream("WEB-INF/actionConfig.properties");
		try {
			ps.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
