package com.kqw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author 
 * 从一个jsp页面上使用get方式提交三个文本框(填数字)，一个下拉列表，下拉列表中两个选项（max,min）到Servlet，
 *Servlet根据传过来的数据,如果是max,求出这个三个数的最大值，否则最小值，然后打印到客户端
 *（待完善）
 */
public class Test9 extends HttpServlet {

	public void service(ServletRequest req, ServletResponse res)
		throws ServletException, IOException {
		System.out.println("服务开始了");
		HttpServletRequest request=(HttpServletRequest)req;
		String method = request.getMethod();
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		if("post".equalsIgnoreCase(method)){
			req.setCharacterEncoding("utf-8");
			String temp1=request.getParameter("wenben1");
			int wenben1=Integer.parseInt(temp1);
			String temp2=request.getParameter("wenben2");
			int wenben2=Integer.parseInt(temp2);
			String temp3=request.getParameter("wenben3");
			int wenben3=Integer.parseInt(temp3);
			String xia=request.getParameter("xia");
			if("max".equalsIgnoreCase(xia)){
				int max=wenben1;
				if(wenben2>max){
					max=wenben2;
				}
				if(wenben3>max){
					max=wenben3;
				}
				out.print("最大值为："+max);
			}else{
				int min=wenben1;
				if(wenben2<min){
					min=wenben2;
				}
				if(wenben3<min){
					min=wenben3;
				}
				out.print("最小值为："+min);
			}
		}else{
			req.setCharacterEncoding("utf-8");
			String temp1=request.getParameter("wenben1");
			int wenben1=Integer.parseInt(temp1);
			String temp2=request.getParameter("wenben2");
			int wenben2=Integer.parseInt(temp2);
			String temp3=request.getParameter("wenben3");
			int wenben3=Integer.parseInt(temp3);
			String xia=request.getParameter("xia");
			if("max".equalsIgnoreCase(xia)){
				int max=wenben1;
				if(wenben2>max){
					max=wenben2;
				}
				if(wenben3>max){
					max=wenben3;
				}
				out.print("最大值为："+max);
			}else{
				int min=wenben1;
				if(wenben2<min){
					min=wenben2;
				}
				if(wenben3<min){
					min=wenben3;
				}
				out.print("最小值为："+min);
			}
		}
		
	}

}
