package servletWork;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/*
 * 7.дһ��servlet���̳�GenericServlet),�������е�ͷ��Ϣ���ҵ�������ַ����Ϣ��Ȼ���ӡ���ͻ���
 * */
public class Myservlet07 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		StringBuffer header = request.getRequestURL();
		System.out.println(header);
	}

}
