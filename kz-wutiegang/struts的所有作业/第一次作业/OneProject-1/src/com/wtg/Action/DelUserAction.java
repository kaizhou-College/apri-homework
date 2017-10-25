package com.wtg.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wtg.Dao.UserDao;
import com.wtg.entity.Users;

public class DelUserAction implements Action{

	public ActionForward excute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(req.getParameter("id"));
		int delUser = UserDao.delUser(Users.class, id);
		if (delUser>0) {
			return new ActionForward("showUser.action", true);
		}else{
			return new ActionForward("error.jsp", true);
		}
		
	}

}
