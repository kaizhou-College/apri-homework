package servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDao;
import entity.Users;

public class SearchServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		System.out.println("进入SearchServlet");
		String uname  = req.getParameter("uname");
		uname = URLDecoder.decode(uname,"utf-8");
		System.out.println("uname="+uname);
		//1,根据uname查询数据库
		List<Users> us = new UsersDao().find(uname);
		//1, 文本  2，xml
		StringBuffer sb = new StringBuffer();
		for(Users u :us){
			sb.append(u.getUname()+"-");
		}
		sb.substring(0, sb.length()-2);
		System.err.println(sb);
		out.print(sb);
	}
}
