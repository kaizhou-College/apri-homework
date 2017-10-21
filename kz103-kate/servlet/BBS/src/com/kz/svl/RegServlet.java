package com.kz.svl;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kz.dao.BaseDao;
import com.kz.entity.Users2;

public class RegServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1,编码
		
		//2，取值
		String uname = req.getParameter("uname");
		String password = req.getParameter("pwd");
		Users2 t = new Users2();
		t.setUname(uname);
		t.setUpassword(password);
		//3,调dao
		new BaseDao<Users2>().save("seq_users2", t);
		//4,跳转---是否可以直接掉到jsp?jsp中是否有数据
		//有数据，不能直接跳到jsp 而是先去servlet取数据 再从servlet跳到改jsp
		resp.sendRedirect("FindMsgServlet");
		
		
	}
}
