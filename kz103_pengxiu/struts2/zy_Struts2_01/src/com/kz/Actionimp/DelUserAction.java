package com.kz.Actionimp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kz.Action.Action;
import com.kz.dao.UsersDao;
import com.kz.entity.ActionForward;
import com.kz.entity.Users;

public class DelUserAction implements Action{
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) {
		int id=Integer.parseInt(req.getParameter("id"));
		List<Users> list=UsersDao.Insert();
		list.remove(id);
		return new ActionForward("showUser.action",false);
	}
}
