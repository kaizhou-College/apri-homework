package com.kz.serlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;

import com.kz.dao.UsersDao;
import com.kz.entity.Users;

public class servlet08 extends HttpServlet {
	public servlet08() {
		super();
	}
	public void destroy() {
		super.destroy();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		List<Users> selID = UsersDao.selID(id);
		if(selID.size()>0){
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			UsersDao.Update(id, name, pwd);
			out.print("ok");
		}else{
			out.print("error");
		}
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
