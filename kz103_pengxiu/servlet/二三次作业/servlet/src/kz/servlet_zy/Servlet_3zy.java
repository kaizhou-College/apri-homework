package kz.servlet_zy;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet_3zy implements Servlet{
	int i=0;	
	public int Servlet_3zy(){
		int j=0;
			System.out.println("������"+j+1+"��");
			j=j+1;
		
		return j;
	}
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("����");
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.getServletConfig();
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return getServletInfo()+"�����������������ڵ�";
	}

	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("����");
		
	}

	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {

		 StringBuffer sb=new StringBuffer();
		 Servlet_3zy ser=new Servlet_3zy();
		 sb.append(ser.Servlet_3zy());
		 try {
		 FileWriter fw=new FileWriter("C:/Users/www/Desktop/sql��ҵ/�½��ı��ĵ�");
		 fw.write(sb.toString());
		 fw.close();
		} catch (IOException e) {
		 e.printStackTrace();
		 }
		 
	}
	public static void main(String[] args) {
		 StringBuffer sb=new StringBuffer();
		 Servlet_3zy ser=new Servlet_3zy();
		 sb.append(ser.Servlet_3zy());
		 try {
		 FileWriter fw=new FileWriter("C:/Users/www/Desktop/sql��ҵ/�½��ı��ĵ�");
		 fw.write(sb.toString());
		 fw.close();
		} catch (IOException e) {
		 e.printStackTrace();
		 }
		 }
	

}
