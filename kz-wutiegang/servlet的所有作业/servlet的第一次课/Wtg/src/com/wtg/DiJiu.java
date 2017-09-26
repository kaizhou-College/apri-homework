package com.wtg;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class DiJiu extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("开始服务了");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		FileInputStream fis=new FileInputStream("E:\\360用户文件\\a.txt");
		InputStreamReader is=new InputStreamReader(fis);
		BufferedReader br=new BufferedReader(is);
		String line = br.readLine();
		while(line!=null){
			out.print(line);
			line = br.readLine();
		}
		fis.close();
		is.close();
		br.close();
		out.close();
	}

}
