package work03;
/**
 * 1.дһ�����ӣ�����filter��servlet����������
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class filter01 implements Filter {

	public filter01(){
		System.out.println("��������������");
	}
	@Override
	public void destroy() {
		System.out.println("��������������");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			System.out.println("������ִ�м�顭��");
			//����
			chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("��������ʼ����");
	}

}
