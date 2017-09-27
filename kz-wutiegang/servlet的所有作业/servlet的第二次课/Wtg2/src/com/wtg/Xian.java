package com.wtg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.BookDao;
import com.Dao.impl.BookDaoImpl;
import com.entity.Book;

public class Xian extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		BookDao bookdao=new BookDaoImpl();
		ArrayList<Book> list = bookdao.getAllById(-1);
		request.setAttribute("list", list);
		request.getRequestDispatcher("show.jsp").forward(request, response);
		
	}

}
