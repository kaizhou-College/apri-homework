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
		//1,����
		
		//2��ȡֵ
		String uname = req.getParameter("uname");
		String password = req.getParameter("pwd");
		Users2 t = new Users2();
		t.setUname(uname);
		t.setUpassword(password);
		//3,��dao
		new BaseDao<Users2>().save("seq_users2", t);
		//4,��ת---�Ƿ����ֱ�ӵ���jsp?jsp���Ƿ�������
		//�����ݣ�����ֱ������jsp ������ȥservletȡ���� �ٴ�servlet������jsp
		resp.sendRedirect("FindMsgServlet");
		
		
	}
}
