package com.tl.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
/**
 * 编码问题解决
 * @author Administrator
 *
 */
public class MyServlet1 extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
		Map<String,String[]> map = null ;
		HttpServletRequest request= (HttpServletRequest)req;
		if(request.getMethod().equals("POST")){
			request.setCharacterEncoding("utf-8");
		}else if(request.getMethod().equals("GET")){
			map = request.getParameterMap();
			Collection<String[]> collection = map.values();
			for (String[] keys:collection) {
				for(int i=0;i<keys.length;i++){
					keys[i] = new String(keys[i].getBytes("iso-8859-1"),"utf-8");
				}
			}
		}
		for (String key : map.keySet()) {
			String[] values = map.get(key);
			for (int i = 0; i < values.length; i++) {
				System.out.println("key:"+key+"value:"+values[i]);
			}
		}
	}
	
	
	
}
