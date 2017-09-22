package servletwork;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;

import entity.User;

public class servlet12 {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		User user = new User(name, password);
		int add = UserDao.Add(user);
		if(add>0){
			out.print("添加成功");
		}else{
			out.print("添加失敗");
		}
	}
}
