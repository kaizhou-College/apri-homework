package com.wtg.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wtg.Dao.UserDao;
import com.wtg.entity.Users;

public class AddUserAction implements Action{

	public ActionForward excute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String psw = req.getParameter("psw");
		
		Users u=new Users(username, psw);
		int addUser = UserDao.addUser("aa", u);
		if (addUser>0) {
			return new ActionForward("success.jsp", true);
		}else{
			return new ActionForward("error.jsp", true);
		}
	
	}

}
