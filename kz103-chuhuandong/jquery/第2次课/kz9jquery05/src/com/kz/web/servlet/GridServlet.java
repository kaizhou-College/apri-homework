package com.kz.web.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kz.dao.UsersDao;
import com.kz.entity.Users;

public class GridServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("����");
		//plain �ı�   html ���ı�
		resp.setContentType("text/plain;charset=utf-8");
		String spage = req.getParameter("page");
		String srows = req.getParameter("rows");
		int page = Integer.parseInt(spage);
		int rows = Integer.parseInt(srows);
		//biz--dao----���ݿ�
		List<Users> users = new UsersDao().findByPage(page, rows);
		//������תΪjson�ַ���
		Gson gson = new Gson();
		String jsonUsers = gson.toJson(users);
		String json = "{\"total\":21,\"rows\":"+jsonUsers+"}";
		System.out.println("jsonUsers"+json);
		resp.getWriter().write(json);
	}
}
