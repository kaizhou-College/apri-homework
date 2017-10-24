package com.kz.controller;

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

import com.kz.action.Action;
import com.kz.action.impl.ActionForward;
import com.kz.action.impl.ManAction;
//����ҽԺ�ķ���������Һţ�����
public class MyFilter implements Filter {
	private Properties ps;
	public void destroy() {

	}
	//����һ�� ����һ��
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//ǿת
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//�Һţ�
		//1.��Ҫ֪���Ǹ����ڿ�ʲô�ƣ������ļ��ķ�ʽ .properties
		//init()-----web����
		//2,֪������Ҫ��ʲô�ƣ�
		//kz9struts2-01/man.action
		String uri = req.getRequestURI();
		//��ȡman.action 1��substring  2)File
		File file = new File(uri);
		String bing = file.getName();
		System.out.println("bing==="+bing);
		
		//3,��ʼ����(����)
		//3.1�ҵ�ҽ��
		String actionName = ps.getProperty(bing);
		System.out.println("action="+actionName);
		try {
			Class actionClazz = Class.forName(actionName);
			Action action = (Action) actionClazz.newInstance();
			//3.2����ҽ������
			//String re = action.excute();
			ActionForward af = action.excute(req,resp);
			//4,��ʾ�������صĽ��(1,ת���� 2���ض���)
			//Ĭ�Ͼ���ת��
			//��ʽһ
			/*if(re.contains("redirect:")){
				//�ض���
				resp.sendRedirect(re.substring(re.indexOf(":")+1)+".jsp");
			}else{
				if(bing.contains("woman")){
					req.setAttribute("info","������");
				}else{
					req.setAttribute("info","���п�");
				}
				//ת��
				req.getRequestDispatcher(re+".jsp").forward(req, resp);
			}*/
			//��������
			if(af.isRedirect()){
				//�ض���
				resp.sendRedirect(af.getUrl()+".jsp");
			}else{
				//ת��
				req.getRequestDispatcher(af.getUrl()+".jsp").forward(req, resp);
			}
			
			return;//��������
		} catch (Exception e) {
			e.printStackTrace();
		}
		//����
		chain.doFilter(request, response);
	}
	/*
	 * ֻ�����һ��(non-Javadoc)
	 * ��ȡ�����ļ�ֻҪ��һ�ξ͹��ˡ�����ŵ�doFilter������
	 * ����һ�Σ��ͻ��ȡ�����ļ�һ�Ρ�
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		ps = new Properties();
		InputStream in = filterConfig.getServletContext().getResourceAsStream("/WEB-INF/menu.properties");
		try {
			ps.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
