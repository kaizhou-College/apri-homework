package com.wtg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wtg.Dao.BookDao;
import com.wtg.entity.Book;


public class pageServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int Page =1;
		int Pagesize =2;
		
		//判断是否带了参数
		String spage = request.getParameter("currentPage");
		if(spage!=null){
			Page= Integer.parseInt(spage);
		}
		//3,调dao:分页查询的方法
		List<Book> list =BookDao.selByPage(Pagesize, Page);
		//得到总页数
		int max = BookDao.getMaxPage(Pagesize);
		System.out.println("list.size()==="+list.size());
		//4,跳到jsp:跳到首页显示第1页数据
		if(list.size()>0){
			request.setAttribute("list",list);
			request.setAttribute("page",Page);
			request.setAttribute("max",max);
			request.getRequestDispatcher("MyJsp4.jsp").forward(request, response);
		}
		
		
	}

}
