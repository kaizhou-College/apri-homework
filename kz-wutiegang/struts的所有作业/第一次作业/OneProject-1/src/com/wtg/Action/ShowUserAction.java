package com.wtg.Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wtg.Dao.UserDao;
import com.wtg.entity.Users;

public class ShowUserAction implements Action{

	public ActionForward excute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		try {
			List showUser = UserDao.showUser(Users.class);
			req.setAttribute("list", showUser);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ActionForward("show.jsp", false);
	}

}
