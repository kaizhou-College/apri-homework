package com.kz.serlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kz.dao.UsersDao;
import com.kz.entity.Users;

public class servlet05 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html:charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		List<Users> list = UsersDao.getUsers();
		if(list.size()>0){
			for(int i =0;i<list.size();i++){
				if(name.equals(list.get(i).getName())){
					if(pwd.equals(list.get(i).getPwd())){
						request.setAttribute("name", name);
						request.setAttribute("pwd", pwd);
						request.getRequestDispatcher("servlet05_2.jsp").forward(request, response);
					}else{
						out.print("<script type='text/javascript'>alter('密码不正确');</script");
					}
				}else{
					out.print("<script type='text/javascript'>alter('没有此用户');</script");
				}
			}
		}
	}
}
