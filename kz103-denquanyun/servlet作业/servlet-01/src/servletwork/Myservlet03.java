package servletwork;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class Myservlet03 implements Servlet{
	private int count;//���������Ĵ���- -
	public void destroy() {
		// TODO Auto-generated method stub
		File file = new File("D:/�Ҿ�/�����׶�/work3.txt"); 
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(""+this.count);
			
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.count);
		
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
			this.count = this.count+1;
			System.out.println("���Ҿ��㲻��ɧ�˻������ֻ��۹����");
		
	}

}
