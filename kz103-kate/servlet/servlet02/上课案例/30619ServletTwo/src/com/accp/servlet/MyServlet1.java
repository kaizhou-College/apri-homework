package com.accp.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet1 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		//System.out.println("进来了。。。");
		
		//request强制转换
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		//获取请求的类型:get/post
		String method = request.getMethod();
		//判断如果是post请求
		if("POST".equalsIgnoreCase(method)){
			//设置post的请求编码方式
			request.setCharacterEncoding("utf-8");
		}else{
			//以前的实现方式
			//String num  = new String(request.getParameter("number").getBytes("iso-8859-1"),"utf-8");
			//String number  = new String(request.getParameter("uname").getBytes("iso-8859-1"),"utf-8");
			
			//获取表单中所有参数的name,返回的是一个迭代器集合
			//Enumeration相当于Iterator
			Enumeration<String> ems =  request.getParameterNames();
			//判断迭代集合中是否有下一个元素
			while(ems.hasMoreElements()){
				//取出迭代集合中的下一个元素
				String name = ems.nextElement();
				//根据取到的name，获取表单中name所对应的value值
				String [] values = request.getParameterValues(name);
				//循环数组的中每个值，对其转码
				for(int i=0;i<values.length;i++){
					//转码，并级数组的第i位重新赋值
					values[i] = new String(values[i].getBytes("iso-8859-1"),"utf-8");
				}
			}
		}
		
		//设置响应的编码方式
		response.setContentType("text/html;charset=utf-8");
		
		//测试，获取值，打印输出
		//直接获值，不需要再关注post和get方式的编码问题
		String num = request.getParameter("number");
		String uname = request.getParameter("uname");
		String [] hbs = request.getParameterValues("hobby");
		
		System.out.println("编号:"+num);
		System.out.println("姓名:"+uname);
		System.out.println("爱好:");
		for(String str:hbs){
			System.out.print(str+" ");
		}
		
		
	}

	
}
