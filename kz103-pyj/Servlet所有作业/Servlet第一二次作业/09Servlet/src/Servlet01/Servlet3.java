package Servlet01;

/**
 * 3.дһ����ʵ��Servlet�ӿ�,ͳ�ƴ�servlet�������˶��ٴΣ�
 * ������ͻ���,�����ٴ�Servlet��ʱ�򣬽��������д��
 *Ӳ�̵��ı��ĵ���.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet3 implements Servlet {
	private int i = 0;
	private ServletConfig servletConfig;
	public Servlet3() {
		System.out.println("servlet��������");
	}
	public void destroy() {
		//����
		System.out.println("Servlet3��������");
		File file = new File("E:/a.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			fw.write(""+this.i);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(fw!=null){
					fw.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	public void init() throws ServletException {
		
	}
	public ServletConfig getServletConfig() {
		return this.getServletConfig();
	}
	public String getServletInfo() {
		return "����servletwork03	���������ڵķ���";
	}
	public void init(ServletConfig config) throws ServletException {
		System.out.println("��ʼ����ʼ");
		this.servletConfig = config;
	}

	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			i=i+1;
			out.print("����һ��"+i+"��");
	}

}