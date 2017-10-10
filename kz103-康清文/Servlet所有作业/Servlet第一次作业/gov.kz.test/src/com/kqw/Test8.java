package com.kqw;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * @author 
 * 写一个类继承GenericServlet,在service方法中读取硬盘的一个文本文档的内容(自拟),读到方法中，再输出到客户端
 * 
 */
public class Test8 extends GenericServlet{

	
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
			//方式一
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out=res.getWriter();
			FileInputStream fis = new FileInputStream("E:\\test.txt");
			InputStreamReader is=new InputStreamReader(fis);
			BufferedReader br=new BufferedReader(is);
			String meng=br.readLine();
				while(meng!=null){
					out.print(meng+"\t");
					meng=br.readLine();
				
				}
			br.close();
			is.close();
			fis.close();
			out.close();
	
	}

}
