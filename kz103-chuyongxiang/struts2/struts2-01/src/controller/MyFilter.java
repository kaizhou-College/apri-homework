package controller;

import impl.ActionForward;

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

import action.Action;


public class MyFilter implements Filter{
	private Properties ps;

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest) request;//ǿת����
		HttpServletResponse res=(HttpServletResponse) response;//ǿת����
		String uri=req.getRequestURI();//��ȡuri��ַ
		File file=new File(uri);//��uri��Ϊ�ļ�
		String bing=file.getName();//��ȡ�ļ�����������
		System.out.println("�õ�����"+bing);
		String actionname=ps.getProperty(bing);//���Խ����ļ����ѯ������
		System.out.println("actionname"+actionname);
		try {
			Class actionclazz=Class.forName(actionname);//��Class�ļ��л�ȡ
			Action action=(Action) actionclazz.newInstance();//newһ���ӿڵķ���
			ActionForward af=action.execute(req, res);
			if(af.isRedirect()){//�ж����ض�����ת����ʽ
				System.out.println(af);
				res.sendRedirect(af.getUri()+".jsp");//�ض���
			}else{
				req.getRequestDispatcher(af.getUri()+".jsp").forward(req,res);//ת��
			}
			return;//��������
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		chain.doFilter(request, response);//����
		
		
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		ps=new Properties();
		InputStream in=filterConfig.getServletContext().getResourceAsStream("/WEB-INF/actionConfig.properties");
		try {
			ps.load(in);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
