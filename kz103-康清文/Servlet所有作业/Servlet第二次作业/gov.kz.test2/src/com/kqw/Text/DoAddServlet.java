package com.kqw.Text;





import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kqw.Dao.BookDao;
import com.kqw.Dao.impl.BookDaoImpl;
import com.kqw.entity.Book;


public class DoAddServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		int price=Integer.parseInt(request.getParameter("price"));
		String writer=request.getParameter("writer");
		BookDao bookdao=new BookDaoImpl();
		Book book =new Book(name, price, writer);
		bookdao.insert(book);
		response.sendRedirect("MyJsp9.jsp");
	}

}
