package com.wtg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wtg.Dao.BaseDao;
import com.wtg.Dao.BookDao;
import com.wtg.entity.Book;
import com.wtg.entity.Student;

public class ListServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		BookDao bd=new BookDao();
		ArrayList<Book> all = bd.getAll();
		
		request.setAttribute("list", all);
		request.getRequestDispatcher("MyJsp1.jsp").forward(request, response);
	}

}
